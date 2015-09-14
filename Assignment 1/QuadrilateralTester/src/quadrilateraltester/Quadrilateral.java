
package quadrilateraltester;

/**
 *
 * @author Jacob Reed
 */
public class Quadrilateral {
    
   Point point1, point2, point3, point4;
    /**
     * Quadrilateral Object class
     * @param x1 the first x coordinate.
     * @param y1 the first y coordinate.
     * @param x2 the second x coordinate.
     * @param y2 the second y coordinate.
     * @param x3 the third x coordinate.
     * @param y3 the third y coordinate.
     * @param x4 the fourth x coordinate.
     * @param y4 the fourth y coordinate.
     */
   public Quadrilateral(double x1, double y1, double x2,
           double y2, double x3, double y3, double x4, double y4)
   {
       point1 = new Point(x1,y1);
       point2 = new Point(x2,y2);
       point3 = new Point(x3,y3);
       point4 = new Point(x4,y4);
   }
   /**
    * Retrieves point 1.
    * @return point 1.
    */
   public Point getPoint1()
   {
       return point1;
   }
   /**
    * Retrieves point 2
    * @return point 2
    */
   public Point getPoint2()
   {
       return point2;
   }
   /**
    * Retrieves point 3.
    * @return point 3
    */
   public Point getPoint3()
   {
       return point3;
   }
   /**
    * Retrieves point 4.
    * @return point 4
    */
   public Point getPoint4()
   {
       return point4;
   }
    /**
     * Retrieves the objects information.
     * @return the objects information.
     */
   public String toString()
   {
       return "Coordinates of Quadrilateral are: \n"+printCoor();
   }
   /**
    * Retrieves the points of the given Quadrilateral class or 
    * derived subclass.
    * @return the points of the coordinates.
    */
   public String printCoor()
   {
       return point1.toString()+"  "+point2.toString()+
               "   "+point3.toString()+"   "+point4.toString();
   }
   
}
