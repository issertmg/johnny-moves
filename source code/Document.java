/** The class Document represents a 
 *  document object with its length,
 *  width, thickness, and number of
 *  pages.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */

public class Document extends Item
{
    private final double thickness;
    
    /** This constructor initializes all the
     *  attributes of the document object and
     *  computes for its thickness and 
     *  initializes it.
     * 
     *    @param length the length of the document
     *    @param width the width of the document
     *    @param numberOfPages the number of pages 
     *                         of the document
     * 
     *    @throws IllegalArgumentException if number of pages is less than 1
     */
    public Document(double length, double width, int numberOfPages) throws IllegalArgumentException
    {
        super(length, width, Math.ceil(numberOfPages / 25.0 * 0.2) * 1000);

        if (numberOfPages < 1)
            throw new IllegalArgumentException("Document measurement/s cannot be a negative value or zero.");

        thickness = Math.ceil(numberOfPages/25.0);
    }
    /** This method returns the document thickness
     * 
     *     @return thickness of the document               
     */
    public double getThickness()
    {
        return thickness;
    }
    /** This method returns the smallest measure
     *  between the length, width, and thickness
     *  of the document
     * 
     *     @return smallest measure of the 
     *             document's dimension               
     */
    public double getSmallestMeasure()
    {
        if (length <= width && length <= thickness)
            return length;
        else if (width <= length && width <= thickness)
            return width;
        else
            return thickness;
    }
}