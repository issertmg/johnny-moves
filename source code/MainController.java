import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;


public class MainController implements Runnable
{
    private MainView gui;
    private AdminKeyController adminKeyController;
    private MenuController menuController;
    private RecipientController recipientController;
    private ItemController itemController;
    private ParcelController parcelController;
    private TransactSuccessController transactSuccessController;
    private TransactFailedController transactFailedController;
    private TrackingInfoController trackingInfoController;
    private LoginController loginController;
    private SignUpController signUpController;
    private SignOutController signOutController;
    private ChangePassController changePassController;
    private ReportGenController reportGenController;

    private Machine machine;

    private Recipient recipient;
    private boolean insured;
    private int parcelIndex;
    private ArrayList<Item> items;

    public MainController(MainView gui, Machine machine)
    {
        menuController = new MenuController(gui, this);
        adminKeyController = new AdminKeyController(gui, this);
        recipientController = new RecipientController(gui, this);
        itemController = new ItemController(gui, this);
        parcelController = new ParcelController(gui, this);
        transactSuccessController = new TransactSuccessController(gui, this);
        transactFailedController = new TransactFailedController(gui, this);
        trackingInfoController = new TrackingInfoController(gui, this);
        loginController = new LoginController(gui, this);
        signUpController = new SignUpController(gui, this);
        signOutController = new SignOutController(gui, this);
        changePassController = new ChangePassController(gui, this);
        reportGenController = new ReportGenController(gui, this);

        this.gui = gui;
        this.machine = machine;

        if (!(machine.getAdminKey().equals("")))
            gui.updateCenterPane(gui.LOGIN);

        setupStatusBar();
    }

    public void addRecipient(Recipient recipient)
    {
        this.recipient = recipient;
    }

    public void isInsured(boolean insured)
    {
        this.insured = insured;
        itemController.setup(((RecipientView) gui.getPanel(gui.ADD_RECIPIENT)).getNumberOfItems());
    }

    public void setupItemController(int numItems)
    {
        itemController.setup(numItems);
    }

    public void setupTransactSuccessView()
    {
        ArrayList<Transaction> transactions = machine.getTransactions();
        Transaction transaction = transactions.get(transactions.size() - 1);
        TrackingInfo trackingInfo = transaction.getTrackingInfo();
        Recipient r = transaction.getParcel().getRecipient();

        ((TransactSuccessView) gui.getPanel(gui.TRANSACT_SUCCESS)).setup(trackingInfo.getTrackingNumber(), r.toString() + transaction.toString());
    }

    public void generateReport()
    {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        ArrayList<Transaction> transactionsData = machine.getTransactions();
        LocalDate currentDate = machine.getCurrentDate();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        for (int i = 0; i < transactionsData.size(); i++)
            if (!(currentDate.isAfter(transactionsData.get(i).getTrackingInfo().getDateDelivered())))
                indices.add(i);
        
        String[][] data = new String[indices.size()][5];

        for (int j = 0; j < indices.size(); j++)
        {
            data[j][0] = transactionsData.get(indices.get(j)).getTrackingInfo().getStartDate().format(dateFormatter);
            data[j][1] = transactionsData.get(indices.get(j)).getParcel().getRecipient().getName();
            data[j][2] = transactionsData.get(indices.get(j)).getParcel().getRecipient().getDestination();
            data[j][3] = transactionsData.get(indices.get(j)).getTrackingInfo().getDateDelivered().format(dateFormatter);
            data[j][4] = transactionsData.get(indices.get(j)).getTrackingInfo().getStatus();
        }
        ((ReportGenView) gui.getPanel(gui.GENERATE_REPORT)).setup(data, currentDate.format(dateFormatter));
    }

    public void dispose()
    {
        itemController.disposeItems();
    }

    public void addItem(ArrayList<Item> items)
    {
        this.items = items;
    }

    public void setParcelIndex(int parcelIndex)
    {
        this.parcelIndex = parcelIndex;
    }

    public void createTransaction()
    {
        machine.createTransactionDetails(recipient, parcelIndex, insured, items);
    }
    
    public Machine getMachine()
    {
        return machine;
    }

    public void updateStatusBar()
    {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        gui.updateStatusBar(machine.getCurrentDate().format(df));
    }

    public void run()
    {
        updateStatusBar();
    }

    public void setupStatusBar()
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(this, 1, 1, TimeUnit.SECONDS);
    }
}