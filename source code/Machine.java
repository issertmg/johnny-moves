import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.io.*;

/** The class Machine represents a 
 *  machine that has an admin key,
 *  current date, sequence number,
 *  and holds a list of accounts 
 *  and transactions.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class Machine implements Serializable, Runnable
{
    private ArrayList<Account> accounts;        //the accounts in the machine
    private ArrayList<Transaction> transactions;//the transactions in the machine
    private int sequenceNumber;                 //the sequence number of the parcel to be created
    private LocalDate currentDate;              //the current date being simulated
    private String adminKey;                    //the administrator key for the machine

    /** This constructor initializes all the
     *  attributes of the machine through
     *  loading a data file if it exists, 
     *  and also simulate the days per minute
     *  for the application.
     */
    public Machine()
    {
        loadData();
    }
    /** This method creates a parcel and the transaction
     *  information using the parameters, and also
     *  add the transaction information to the machine's
     *  list of transactions
     * 
     *     @param r the recipient of the parcel
     *     @param parcelIndex the index referring to the parcel type and size
     *     @param insured whether the parcel is insured or not insured
     *     @param items the list of items to be inserted in the parcel
     */
    public void createTransactionDetails(Recipient r, int parcelIndex, boolean insured, ArrayList<Item> items)
    {
        Parcel p = new Parcel(sequenceNumber, r, parcelIndex, insured);
        p.addItems(items);
        transactions.add(new Transaction(p, currentDate));
        sequenceNumber++;
    }
    /** This method returns the information
     *  of the parcel through the passed
     *  tracking number
     * 
     *     @param trackingNumber the tracking number of the transaction
     * 
     *     @return a String containing the
     *             tracking information             
     */
    public String trackParcel(String trackingNumber)
    {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        int transactionIndex = -1;

        for (int i = 0; i < transactions.size(); i++)
            if (transactions.get(i).getTrackingInfo().getTrackingNumber().equalsIgnoreCase(trackingNumber))
                transactionIndex = i;
        
        if (transactionIndex == -1)
            return "   Invalid tracking number, transaction not found.";
        else return "   Current Date:\t" + currentDate.format(dateFormatter) + transactions.get(transactionIndex).getTrackingInfo().toString();
    }
    /** This method returns the status
     *  of the parcel through the passed
     *  tracking number
     * 
     *     @param trackingNumber the tracking number of the transaction
     * 
     *     @return status of the parcel           
     */
    public String getStatusOfParcel(String trackingNumber)
    {
        int transactionIndex = -1;

        for (int i = 0; i < transactions.size(); i++)
            if (transactions.get(i).getTrackingInfo().getTrackingNumber().equalsIgnoreCase(trackingNumber))
                transactionIndex = i;
        
        if (transactionIndex == -1)
            return "";
        
        return transactions.get(transactionIndex).getTrackingInfo().getStatus(); 
    }
    /** This method returns an array pertaining
     *  to the available parcels for the list of
     *  items in the parameter
     * 
     *     @param items the list of items
     * 
     *     @return boolean array of available parcels            
     */
    public boolean[] getParcelOptions(ArrayList<Item> items)
    {
        int parcelSizes[][] = {{14, 9, 1}, {18, 12, 3},
                               {12, 10, 5}, {14, 11, 7}, 
                               {18, 12, 9}, {20, 16, 12}};
        boolean parcelOptions[] = {true, true, true, true, true, true};

        double totalMinMeasure = 0;
        double totalWeight = 0;

        for (int i = 0; i < items.size(); i++)
        {
            for (int j = 0; j < parcelSizes.length; j++)
                if (!(isItemFit(items.get(i), parcelSizes[j]))) //checks if each item fits the parcel size
                    parcelOptions[j] = false;
        
            totalMinMeasure += items.get(i).getSmallestMeasure();   //gets the total of the smallest measure of the items
            totalWeight += items.get(i).getActualWeight();          //gets the total actual weight of the items
        }

        for (int i = 0; i < parcelOptions.length; i++)  //checks if the total of the smallest measure of the items fit the smallest measure of each parcel size
            if (totalMinMeasure > parcelSizes[i][2])
                parcelOptions[i] = false;

        if (totalWeight > 3000) //if total weight exceeds 3000 grams, the flat parcels cannot be an option
        {
            parcelOptions[0] = false;
            parcelOptions[1] = false;
        }

        return parcelOptions;
    }
    /** This method checks whether the
     *  item is able to fit to the parcel 
     *  size in the parameter
     * 
     *     @param item the item
     *     @param parcelSize the parcel size or type
     * 
     *     @return true if the item fits
     *             the parcel size            
     */
    public boolean isItemFit(Item item, int[] parcelSize)
    {
        boolean isFit = true;
        double[] dimension = new double[3];

        if (item instanceof Product)
        {
            dimension[0] = item.getLength();
            dimension[1] = item.getWidth();
            dimension[2] = ((Product)item).getHeight();
        }
        else 
        {
            dimension[0] = item.getLength();
            dimension[1] = item.getWidth();
            dimension[2] = ((Document)item).getThickness();
        }

        //sorts the dimension array in descending order
        for (int i = 0; i < dimension.length - 1; i++)
            for (int j = 0; j < dimension.length - i - 1; j++)
                if (dimension[j] < dimension[j+1])
                {
                    double temp = dimension[j];
                    dimension[j] = dimension [j+1];
                    dimension[j+1] = temp;
                }

        //checks whether each corresponding measure of the product fits the parcel
        for (int i = 0; i < dimension.length; i++)
            if (dimension[i] > parcelSize[i])
                isFit = false;
        
        return isFit;
    }
    /** This method checks whether the
     *  the items fit any parcel size
     * 
     *     @param items the list of items
     * 
     *     @return true if the items fits
     *             any parcel size            
     */
    public boolean isAnyParcelAvailable(ArrayList<Item> items)
    {
        boolean[] parcelOptions = getParcelOptions(items);

        for (int i = 0; i < parcelOptions.length; i++)
            if (parcelOptions[i])
                return true;
        
        return false;
    }
    /** This method creates an account if the
     *  conditions in the method are met, and also
     *  returns a String about the status of the
     *  account creation
     * 
     *     @param username the username of the account
     *     @param password the password of the account
     *     @param confirmPass same as the password of the account
     *     @param key the admin key of the machine
     * 
     *     @return a String about the account
     *             creation status          
     */
    public String createAccount(String username, String password, String confirmPass, String key)
    {
        String success = "Account has been successfully created.";
        String difPass = "Input password does not match confirm password.";
        String wrongKey = "Wrong admin key, please ask admin for assistance.";
        String alreadyTaken = "Username already exists.";
        String noEntry = "No entry, please enter username and/or password.";

        for (int i = 0; i < accounts.size(); i++)
            if (username.equals(accounts.get(i).getUsername()))
                return alreadyTaken;
                
        if (!(password.equals(confirmPass)))
            return difPass;

        if (!(key.equals(adminKey)))
            return wrongKey;

        if (username.equals("") || password.equals(""))
            return noEntry;

        accounts.add(new Account(username, password));
        saveData();
        return success;        
    }
    /** This method changes the password of an 
     *  account if the conditions in the method 
     *  are met, and also returns a String about 
     *  the status of the password change operation
     * 
     *     @param username the username of the account
     *     @param oldPass the old password of the account
     *     @param newPass the new password of the account
     *     @param confirmNewPass same as the new password of the account
     * 
     *     @return a String of the status of the
     *             change password operation          
     */
    public String changePassword(String username, String oldPass, String newPass, String confirmNewPass)
    {
        String success = "Password has been changed successfully.";
        String difPass = "Error: New password does not match confirm new password.";
        String incorrect = "Warning: Incorrect username or password."; 
        String sameOld = "Error: Entered new password is the same as old password.";
        String noNewPass = "Error: No new password input.";
                
        if (!(isAuthorizeLogin(username, oldPass)))
            return incorrect;

        if (!(newPass.equals(confirmNewPass)))
            return difPass;

        if (oldPass.equals(newPass))
            return sameOld;

        if (newPass.equals(""))
            return noNewPass;

        for (int i = 0; i < accounts.size(); i++)
            if (username.equals(accounts.get(i).getUsername()))
                accounts.get(i).setPassword(newPass);
        
        saveData();
        return success;
    }
    /** This method checks if the username and
     *  password in the parameter is authorized
     *  to login to the machine
     * 
     *     @param username the username of an account
     *     @param password the password of an account
     * 
     *     @return true if the username and password
     *             matches an account in the list
     *             of accounts in the machine   
     */
    public boolean isAuthorizeLogin(String username, String password)
    {
        for (int i = 0; i < accounts.size(); i++)
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password))
                return true;
        return false;
    }
    /** This method creates a binary file "machineData.dat"
     *  containing the current state of the the machine object       
     */
    public void saveData()
    {
        try
        {
            FileOutputStream f = new FileOutputStream(new File("machineData.dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(this);

            o.close();
            f.close();
        }
        catch (IOException e)
        {
            System.out.println("Unable to save data.");
        }
    }
    /** This method loads and copies the contents of 
     *  the machine object in the "machineData.dat"
     *  binary file if it is present, otherwise
     *  it will initialize the attributes of the
     *  machine          
     */
    public void loadData()
    {
        try
        {
            FileInputStream fi = new FileInputStream(new File("machineData.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            Machine loadedMachine = (Machine) oi.readObject();

            accounts = loadedMachine.getAccounts();
            transactions = loadedMachine.getTransactions();
            sequenceNumber = loadedMachine.getSequenceNumber();
            currentDate = loadedMachine.getCurrentDate();
            adminKey = loadedMachine.getAdminKey();
            
            oi.close();
            fi.close();
        }
        catch (FileNotFoundException e)
        {
            accounts = new ArrayList<Account>();
            transactions = new ArrayList<Transaction>();
            sequenceNumber = 1;
            currentDate = LocalDate.now();
            adminKey = "";
        }
        catch (IOException i)
        {
            System.out.println("Error initializing stream, setting up new machine...");

            accounts = new ArrayList<Account>();
            transactions = new ArrayList<Transaction>();
            sequenceNumber = 1;
            currentDate = LocalDate.now();
            adminKey = "";
        }
        catch (ClassNotFoundException e) 
        {
            System.out.println("A class was not found, setting up new machine...");
            
            accounts = new ArrayList<Account>();
            transactions = new ArrayList<Transaction>();
            sequenceNumber = 1;
            currentDate = LocalDate.now();
            adminKey = "";
        }
    }
    /** This method calls a function that performs
     *  the incrementing of the current date and 
     *  the updating of parcel statuses every minute
     *  (in real time)          
     */
    public void simulateDayPerMinute()
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(this, 1, 1, TimeUnit.MINUTES);
    }
    /** This method returns the list of accounts
     *  in the machine
     * 
     *     @return ArrayList of Account        
     */
    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }
    /** This method returns the list of transactions
     *  in the machine
     * 
     *     @return ArrayList of Transaction        
     */
    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }
    /** This method returns the sequence number
     *  with regards to the number of parcels 
     *  sent within the current date
     * 
     *     @return sequence number of the next 
     *             parcel to be created in the 
     *             current date       
     */
    public int getSequenceNumber()
    {
        return sequenceNumber;
    }
    /** This method returns the current
     *  date simulated in the machine
     * 
     *     @return current date (simulated)     
     */
    public LocalDate getCurrentDate()
    {
        return currentDate;
    }
    /** This method returns the administrator
     *  key of the machine
     * 
     *     @return a String representation
     *             of the administrator key      
     */
    public String getAdminKey()
    {
        return adminKey;
    }
    /** This method sets the administrator
     *  key attribute of the machine to the
     *  String parameter key
     * 
     *     @param key a String representation
     *             of the administrator key        
     */
    public void setAdminKey(String key)
    {
        adminKey = key;
        saveData();
    }
    /** This method increments the current date
     *  attribute of the machine by 1 day, resets
     *  the sequence number of the next parcel
     *  to be created, and updates the status
     *  of the transactions in the machine    
     */
    public void run()
    {
        currentDate = currentDate.plusDays(1);
        sequenceNumber = 1;
        
        for (int i = 0; i < transactions.size(); i++)
            transactions.get(i).getTrackingInfo().updateStatus(currentDate);
    }
    /** This method terminates the machine
     *  operation    
     */
    public void shutdown()
    {
        System.exit(0);
    }
}