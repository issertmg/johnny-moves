import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

/** The class TrackingInfo represents a 
 *  tracking information object containing
 *  a tracking number, start date,
 *  date of delivery, and delivery status. 
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class TrackingInfo implements Serializable
{
    private final String trackingNumber;    //the tracking number of the parcel
    private final LocalDate dateDelivered;  //the date of delivery of the parcel
    private final LocalDate startDate;      //the date of transaction
    private String status;                  //the status of the parcel delivery
    
    /** This contructor creates the tracking number
     *  of the transaction and initializes all the
     *  attributes of the tracking information object.
     * 
     *    @param p the Parcel object.
     *    @param currentDate the current date.
     */
    public TrackingInfo(Parcel p, LocalDate currentDate)
    {
        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df2 = new DecimalFormat("00");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMdd");

        String parcelType;

        startDate = currentDate;
        status = "Preparing";

        if (p.getParcelIndex() == 0 || p.getParcelIndex() == 1)
            parcelType = "FLT";
        else parcelType = "BOX";
        
        trackingNumber = parcelType + 
                         startDate.format(dateFormatter) + 
                         p.getRecipient().getDestination() + 
                         df2.format(p.getNumberOfItems()) + 
                         df3.format(p.getParcelNumber());

        switch (p.getRecipient().getDestination())
        {
            case "MML" : dateDelivered = currentDate.plusDays(1); break;
            case "LUZ" : dateDelivered = currentDate.plusDays(2); break;
            case "VIS" : dateDelivered = currentDate.plusDays(4); break;
            case "MIN" : dateDelivered = currentDate.plusDays(7); break;
            default : dateDelivered = currentDate.plusDays(1);
        }
    }
    /** This method returns the tracking number of the parcel.
     * 
     *     @return tracking number of the tracking information.                   
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }
    /** This method returns the date of delivery of the parcel.
     * 
     *     @return a LocalDate which is the date of delivery of the parcel                  
     */
    public LocalDate getDateDelivered()
    {
        return dateDelivered;
    }
    /** This method returns the date the tracking info is created.
     * 
     *     @return a LocalDate which is the date creation of the tracking info.             
     */
    public LocalDate getStartDate()
    {
        return startDate;
    }
    /** This method returns the delivery status of the parcel.
     * 
     *     @return a string representing the status of the delivery.                   
     */
    public String getStatus()
    {
        return status;
    }
    /** This method updates the delivery status based on the
     *  parameter current date.
     * 
     *     @param currentDate a LocalDate which is the current date.
     */
    public void updateStatus(LocalDate currentDate)
    {
        if (currentDate.isEqual(dateDelivered) || currentDate.isAfter(dateDelivered))
            status = "Delivered";
        else status = "Shipping";
    }
    /** This method returns the summary of the tracking number, date creation,
     *  and date of delivery of the parcel.
     * 
     *     @return a string of the tracking number, date creation, and date
     *             of delivery of the parcel.                
     */
    public String toString()
    {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        
        return "\n\n   Tracking Number:\t" + trackingNumber +
               "\n   Date of transaction:\t" + startDate.format(dateFormatter) +
               "\n   ETA:\t\t" + dateDelivered.format(dateFormatter);
    }
}