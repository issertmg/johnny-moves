/** The class IrregularShapedProduct 
 *  represents an irregular-shaped
 *  product object with its length,
 *  width, height, actual weight,
 *  and volumetric weight.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */

public class IrregularShapedProduct extends Product
{
    private final double volWeight;

    /** This constructor initializes all the
     *  attributes of the regular-shaped product object
     *  and also computes for the volumetric weight
     *  and initializes it.
     * 
     *    @param length the length of the irregular-shaped product
     *    @param width the width of the irregular-shaped product
     *    @param height the height of the irregular-shaped product
     *    @param actualWeight the actual weight of the irregular-shaped product
     */
    public IrregularShapedProduct(double length, double width, double height, double actualWeight)
    {
        super(length, width, height, actualWeight);
        volWeight = length * width * height / 305 * 1000;
    }
    /** This method returns the volumetric weight
     *  of the irregular-shaped product
     * 
     *     @return volumetric weight of the irregular-shaped product           
     */
    public double getVolWeight()
    {
        return volWeight;
    }
}