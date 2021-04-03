import java.io.Serializable;

/** The abstract class Item represents 
 *  an item with its length, width, 
 *  and actual weight.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public abstract class Item implements Serializable
{
    protected final double length;
    protected final double width;
    protected final double actualWeight;

    /** This constructor initializes all the
     *  attributes of the item.
     * 
     *    @param length the length of the item
     *    @param width the width of the item
     *    @param actualWeight the actual weight of the item
     * 
     *    @throws IllegalArgumentException if length, width, or actual weight is less than or equal to zero
     */
    public Item(double length, double width, double actualWeight) throws IllegalArgumentException
    {
        if (length <= 0 || width <= 0 || actualWeight <= 0)
            throw new IllegalArgumentException("Item measurement/s cannot be a negative value or zero.");
        
        this.length = length;
        this.width = width;
        this.actualWeight = actualWeight;
    }
    /** This method returns the length of the item
     * 
     *     @return length of the item                  
     */
    public double getLength()
    {
        return length;
    }
    /** This method returns the width of the item
     * 
     *     @return width of the item                    
     */
    public double getWidth()
    {
        return width;
    }
    /** This method returns the actual weight of the item
     * 
     *     @return actual weight of the item                    
     */
    public double getActualWeight()
    {
        return actualWeight;
    }
    /** This method returns the smallest measure
     *  of the attributes of the item
     * 
     *     @return smallest measure of the item                  
     */
    public abstract double getSmallestMeasure();
}