import java.io.Serializable;

/** The class Recipient represents a 
 *  recipient object containing
 *  a name and destination. 
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class Recipient implements Serializable
{
    private final String name;
    private final String destination;

    /** This constructor initializes the
     *  recipient's name and destination.
     * 
     *    @param name the name of the recipient
     *    @param destination the destination of the recipient
     */
    public Recipient(String name, String destination)
    {
        this.name = name;
        this.destination = destination;
    }
    /** This method returns the recipient's name
     * 
     *     @return name of the recipient           
     */
    public String getName()
    {
        return name;
    }
    /** This method returns the recipient's destination
     * 
     *     @return destination of the recipient           
     */
    public String getDestination()
    {
        return destination;
    }
    /** This method returns the recipient's name
     *  and destination
     * 
     *     @return a String containing the name and 
     *             destination of the recipient         
     */
    public String toString()
    {
        String destString;

        if (destination.equals("MML"))
            destString = "Metro Manila";
        else if (destination.equals("LUZ"))
            destString = "Provincial Luzon";
        else if (destination.equals("VIS"))
            destString = "Visayas";
        else destString = "Mindanao";
        
        return "\n    Recipient name: " + name + "\n\n    Destination: " + destString + "\n";
    }
}