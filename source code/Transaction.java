import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.text.DecimalFormat;

/** The class Transaction represents a 
 *  transaction object containing 
 *  a base rate fee, delivery fee, 
 *  insurance fee, tracking information, 
 *  and the parcel linked to the 
 *  transaction. 
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class Transaction implements Serializable
{
    private Parcel parcel;
    private TrackingInfo trackingInfo;
    private double baseRateFee;
    private double deliveryFee;
    private double insuranceFee;

    /** This constructor initializes all the
     *  attributes of the transaction object.
     * 
     *    @param p the parcel object
     *    @param currentDate the current date
     */
    public Transaction(Parcel p, LocalDate currentDate)
    {
        parcel = p;
        trackingInfo = new TrackingInfo(p, currentDate);
        computeFees();
    }
    /** This method computes for the fees of
     *  the transaction through the parcel
     *  attributes and initializes the
     *  base rate fee, delivery fee, and
     *  insurance fee for the transaction
     */
    public void computeFees()
    {
        double regDocWeight = 0;
        double irregAcWeight = 0;
        double irregVolWeight = 0;
        double irregCost = 0;
        ArrayList<Item> items = parcel.getItems();
        String destination = parcel.getRecipient().getDestination();
        int parcelIndex = parcel.getParcelIndex();

        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i) instanceof RegularShapedProduct || items.get(i) instanceof Document)
                regDocWeight += items.get(i).getActualWeight();
            else
            {
                irregAcWeight += items.get(i).getActualWeight();
                irregVolWeight += ((IrregularShapedProduct)items.get(i)).getVolWeight();
            }
        }

        if (destination.equals("MML"))
            deliveryFee = 50.0;
        else if (destination.equals("LUZ"))
            deliveryFee = 100.0;
        else if (destination.equals("VIS"))
        {
            if (irregAcWeight > irregVolWeight) //checks whichever is highest between actual weight and volumetric weight to be used in computing cost of irregular product
                irregCost = 0.10 * irregAcWeight;
            else irregCost = 0.10 * irregVolWeight;

            if (1000 > (regDocWeight * 0.10) + irregCost)   //checks whichever is higher between 1000 and the sum of 10% actual weight of product and cost of irregular product
                deliveryFee = 1000; 
            else deliveryFee = (regDocWeight * 0.10) + irregCost;
        }
        else if (destination.equals("MIN"))
        {
            if (irregAcWeight > irregVolWeight) //checks whichever is highest between actual weight and volumetric weight to be used in computing cost of irregular product
                irregCost = 0.25 * irregAcWeight;
            else irregCost = 0.25 * irregVolWeight;

            if (3000 > (regDocWeight * 0.25) + irregCost)   //checks whichever is higher between 3000 and the sum of 25% actual weight of product and cost of irregular product
                deliveryFee = 3000; 
            else deliveryFee = (regDocWeight * 0.25) + irregCost;
        }

        if (parcelIndex == 0)
            baseRateFee = 30.0;
        else if (parcelIndex == 1)
            baseRateFee = 50.0;
        else
        {
            if (30 * Math.ceil(irregVolWeight/1000) > 40 * Math.ceil(irregAcWeight/1000))    //checks whichever is higher between cost of for weight and volume of products
                baseRateFee = 30 * Math.ceil(irregVolWeight/1000) + 40 * Math.ceil(regDocWeight/1000);
            else baseRateFee = 40 * Math.ceil(irregAcWeight/1000) + 40 * Math.ceil(regDocWeight/1000);
        }

        if (parcel.isInsured())
            insuranceFee = 5.0 * items.size();
        else insuranceFee = 0;
    }
    /** This method returns the transaction's
     *  base rate fee
     * 
     *     @return base rate fee of the transaction        
     */
    public double getBaseRateFee()
    {
        return baseRateFee;
    }
    /** This method returns the transaction's
     *  delivery fee
     * 
     *     @return delivery fee of the transaction        
     */
    public double getDeliveryFee()
    {
        return deliveryFee;
    }
    /** This method returns the transaction's
     *  insurance fee
     * 
     *     @return insurance fee of the transaction        
     */
    public double getInsuranceFee()
    {
        return insuranceFee;
    }
    /** This method returns transaction's
     *  total fee which is the sum of the
     *  base rate fee, delivery fee, and
     *  insurance fee
     * 
     *     @return total fee of the transaction        
     */
    public double getTotalFee()
    {
        return baseRateFee + deliveryFee + insuranceFee;
    }
    /** This method returns the parcel of the transaction
     * 
     *     @return parcel of the transaction        
     */
    public Parcel getParcel()
    {
        return parcel;
    }
    /** This method returns the transaction's
     *  tracking information
     * 
     *     @return tracking information of the transaction        
     */
    public TrackingInfo getTrackingInfo()
    {
        return trackingInfo;
    }
    /** This method returns the base rate fee,
     *  delivery fee, insurance fee, and
     *  total fee of the transaction
     * 
     *     @return a String containing
     *             the base rate fee, delivery fee, insurance
     *             fee, and total fee of the transaction
     */
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        
        return "\n    Breakdown of Fees:\n" +
        "\n            Base rate fee:\tPhp " + df.format(baseRateFee) +
        "\n            Delivery fee:\tPhp " + df.format(deliveryFee) +
        "\n            Insurance fee:\tPhp " + df.format(insuranceFee) +
        "\n\n            Total fee:\tPhp " + df.format(getTotalFee());
    }
}