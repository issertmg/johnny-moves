import java.util.ArrayList;
import java.io.Serializable;

/** The class Parcel represents a
 *  parcel object containing
 *  the recipient information,
 *  items, parcel index, parcel
 *  number and whether it is
 *  insured or not.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class Parcel implements Serializable
{
    private Recipient recipient;    //the recipient of the parcel
    private ArrayList<Item> items;  //the items inside the parcel
    private boolean insured;        //represents if the parcel is insured or not insured
    private int parcelIndex;        //integer representation of the parcel type and size
    private int parcelNumber;       //sequence number of the parcel

    /** This constructor initializes the
     *  parcel's number, recipient, index
     *  and whether the parcel is insured.
     * 
     *    @param parcelNumber the number of the parcel
     *    @param r the recipient of the parcel
     *    @param parcelIndex the integer representation of the parcel's type
     *    @param insured the boolean representation of whether the parcel is insured
     */
    public Parcel(int parcelNumber, Recipient r, int parcelIndex, boolean insured)
    {
        this.parcelNumber = parcelNumber;
        recipient = r;
        this.parcelIndex = parcelIndex;
        this.insured = insured;
    }
    /** This method adds items to the parcel
     *  through the parameter
     * 
     *     @param items an ArrayList containing Item objects     
     */
    public void addItems(ArrayList<Item> items)
    {
        this.items = items;
    }
    /** This method returns the items in
     *  the parcel
     * 
     *     @return an ArrayList containing Item objects
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }
    /** This method returns the number of items
     *  in the parcel
     * 
     *     @return number of items in the parcel           
     */
    public int getNumberOfItems()
    {
        return items.size();
    }
    /** This method returns the parcel index
     *  which is the integer representation
     *  of the parcel type
     * 
     *     @return parcel index          
     */
    public int getParcelIndex()
    {
        return parcelIndex;
    }
    /** This method returns the parcel number
     * 
     *     @return the parcel number     
     */
    public int getParcelNumber()
    {
        return parcelNumber;
    }
    /** This method returns the parcel's
     *  recipient
     * 
     *     @return the recipient of the parcel           
     */
    public Recipient getRecipient()
    {
        return recipient;
    }
    /** This method returns whether the parcel
     *  is insured or not insured.
     * 
     *     @return true if the parcel is insured        
     */
    public boolean isInsured()
    {
        return insured;
    }
}