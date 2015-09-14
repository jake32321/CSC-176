
package quadrilateraltester;

/**
 *
 * @author Jacob Reed
 */
public class Trapezoid extends Quadrilateral {
     /**
     * Trapezoid Object class
     * @param x1 the first x coordinate.
     * @param y1 the first y coordinate.
     * @param x2 the second x coordinate.
     * @param y2 the second y coordinate.
     * @param x3 the third x coordinate.
     * @param y3 the third y coordinate.
     * @param x4 the fourth x coordinate.
     * @param y4 the fourth y coordinate.
     */
    public Trapezoid(double x1, double y1, double x2, double y2, 
            double x3, double y3, double x4, double y4)
    {
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    /**
     * Retrieves the height of the object after running 
     * a conditional test to determine
     * the method to find the height.
     * @return the height of the object.
     */
    public double getHeight()
    {
        if(getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint2().getY()-getPoint3().getY());
        else
            return Math.abs(getPoint1().getY()-getPoint2().getY());
    }
    /**
     * Retrieves the sum of both the base and top 
     * line after running a conditional test to 
     * determine the method to find the sum of the sides.
     * @return the sum of the sides.
     */
    public double sumOfSides()
    {
        if(getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint1().getX()-getPoint2().getX())+
                    Math.abs(getPoint3().getX()-getPoint4().getX());
        else
            return Math.abs(getPoint2().getX()-getPoint3().getX())+
                    Math.abs(getPoint4().getX()-getPoint1().getX());
    }
    /**
     * Retrieves the area using the appropriate formula.
     * @return the area.
     */
    public double getArea()
    {
        return (sumOfSides()*getHeight())/2.0;
    }
    /**
     * Retrieves all the information about the given object.
     * @return all of the objects information.
     */
    public String toString()
    {
        return "The points, height and area of the Trapezoid "
                + "are as follows: "+"\nPoints: "+printCoor()+"\nHeight: "
                +getHeight()+"\nArea: "+getArea();
    }
}
