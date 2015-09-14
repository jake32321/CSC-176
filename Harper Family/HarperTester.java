/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harpertester;

/**
 *
 * @author Jacob Reed
 */
public class HarperTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BuildingOccupancy harperHouse = new BuildingOccupancy(5);
        
        System.out.println("The total occupants are: "
                +harperHouse.totalOccupancy());
        harperHouse.addOccupant(3);
        harperHouse.addOccupant(4);
        harperHouse.addOccupant(4);
        harperHouse.addOccupant(5);
        System.out.println("The total occupants are: "
                +harperHouse.totalOccupancy());
        harperHouse.removeOccupant(3);
        System.out.println("Ball cap wearing person removed...");
        System.out.println("The percentage of empty rooms is: "+
                harperHouse.pctEmpty());
        harperHouse.incrementAll();
        System.out.println("The most occupied room has "
                +harperHouse.maxOccupancy()+" people in it.");
        
    }
}
