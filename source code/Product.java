/** The class Product represents a 
 *  product object with length,
 *  width, height, and actual weight.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class Product extends Item
{
    protected final double height;
    
    /** This constructor initializes all the
     *  attributes of the product object.
     * 
     *    @param length the length of the product
     *    @param width the width of the product
     *    @param height the height of the product
     *    @param actualWeight the actual weight of the product
     * 
     *    @throws IllegalArgumentException if height is less than or equal to zero
     */
    public Product(double length, double width, double height, double actualWeight) throws IllegalArgumentException
    {
        super(length, width, actualWeight);

        if (height <= 0)
            throw new IllegalArgumentException("Product measurement/s cannot be a negative value or zero.");

        this.height = height;
    }
    /** This method returns the product height
     * 
     *     @return height of the product               
     */
    public double getHeight()
    {
        return height;
    }
    /** This method returns the smallest measure
     *  between the length, width, and height
     *  of the product
     * 
     *     @return smallest measure of the product dimension               
     */
    public double getSmallestMeasure()
    {
        if (length <= width && length <= height)
            return length;
        else if (width <= length && width <= height)
            return width;
        else
            return height;
    }
}