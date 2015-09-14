
package quadrilateraltester;

/**
 *
 * @author Jacob Reed
 */
public class Parallelogram extends Quadrilateral {
    /**
     * Parallelogram Object class
     * @param x1 the first x coordinate.
     * @param y1 the first y coordinate.
     * @param x2 the second x coordinate.
     * @param y2 the second y coordinate.
     * @param x3 the third x coordinate.
     * @param y3 the third y coordinate.
     * @param x4 the fourth x coordinate.
     * @param y4 the fourth y coordinate.
     */
    public Parallelogram(double x1, double y1, double x2, double y2,
            double x3, double y3, double x4, double y4)
    {
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    /**
     * Retrieves the width of the Parallelogram Object.
     * @return the width.
     */
    public double getWidth()
    {
        if(getPoint1().getY()  == getPoint2().getX())
            return Math.abs(getPoint1().getX()-getPoint2().getX());
        else
            return Math.abs(getPoint4().getX()-getPoint3().getX());
    }
    /**
     * Retrieves the height of the Parallelogram Object.
     * @return the height.
     */
     public double getHeight()
    {
        if(getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint2().getY()-getPoint3().getY());
        else
            return Math.abs(getPoint1().getY()-getPoint2().getY());
    }
    /**
     * Retrieves the area of the Parallelogram Object.
     * @return the area
     */
    public double getArea()
    {
        return getWidth()*getHeight();
    }
    /**
     * Returns all information of the Parallelogram Object.
     * @return objects information.
     */
    public String toString()
    {
        return "The points, height and area of the "
                + "Parallelogram are as follows: "+"\nPoints: "+printCoor()+
                "\nArea: "+getArea()+"\nWidth: "+getWidth()+
                "\nHeight: "+getHeight();
    } 
}
