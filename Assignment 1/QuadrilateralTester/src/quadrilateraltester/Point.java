
package quadrilateraltester;

/**
 *
 * @author Jacob Reed
 */
public class Point {
    
    private double x,y;
    /**
     * 
     * @param xCoor the x coordinate of the given point.
     * @param yCoor the y coordinate of the given point.
     */
    public Point(double xCoor, double yCoor)
    {
        x = xCoor;
        y = yCoor;
    }
    /**
     * Retrieves the x coordinate for a given point.
     * @return the x coordinate.
     */
    public double getX()
    {
        return x;
    }
    /**
     * Retrieves the y coordinate of the given point.
     * @return the y coordinate.
     */
    public double getY()
    {
        return y;
    }
    /**
     * Retrieves the whole (x,y) coordinate point.
     * @return (x,y) coordinate point.
     */
    public String toString()
    {
        return "( "+getX()+", "+getY()+" )";
    }
}
