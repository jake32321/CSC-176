/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harpertester;

import java.util.Scanner;
/**
 *
 * @author Jacob Reed
 */
public class BuildingOccupancy {
    
    private int numOfRooms;
    private int[] personsPerRoom;
    Scanner prompt = new Scanner(System.in);
    /** Creates a new building whose occupancy in each room can be tracked.
     * Each room in the new building begins with an occupancy of zero.
     * @param n The total number of rooms in the new building.
     */
    public BuildingOccupancy(int n)
    {
        numOfRooms = n;
        personsPerRoom = new int[numOfRooms];
    }
    /**This method returns the number of rooms in the building.
     * @return The number of rooms in the building.
     */
    public int getRoomCount()
    {
        return numOfRooms;
    }
    /**This method increases the occupancy of a room by one.
     * @param roomNum the number of the room whose occupancy is to
     * be increased; this value should be between 1 and getRoomCount()
     */
    public void addOccupant(int roomNum)
    {
        int indexOf = roomNum--;
        personsPerRoom[indexOf]++;
    }
    /**This method decreases the occupancy of a room by one.
     * If a room begins with an occupancy of zero, its occupancy will
     * not be lowered by this method; this method should only be called 
     * only with rooms that have one or more persons in them.
     * @param roomNum the number of the room whose occupancy is to
     * be decreased; this value should be between 1 and getRoomCount()
     */
    public void removeOccupant(int roomNum)
    {
        int indexOf = roomNum--;
        if(personsPerRoom[indexOf] >= 1)
            personsPerRoom[indexOf]--;
    }
    /**This method returns the total number of occupants in the building.
     * If a room has zero persons in it, the total will remain the same.
     * @return The total number of persons currently in the building.
     */
    public int totalOccupancy()
    {
        int total = 0;
        for (int i : personsPerRoom)
            total = total + i;
        return total;
    }
    /**This method calculates the percentage of rooms that have no persons.
     * Searches for empty rooms throughout the array and adds them to a 
     * running total to be divided by the total number of rooms in the 
     * building; Multiplies that number by 100 to get a easy to read 
     * percentage.
     * @return The percentage of the rooms that have no persons in them. 
     */
    public double pctEmpty()
    {
        int emptyRooms = 0;
        double pct; 
        for (int i : personsPerRoom)
        {
            if(personsPerRoom[i] == 0)
                emptyRooms++;
        }
        pct = (emptyRooms/numOfRooms)*100;
        return pct;
    }
    /**Adds one person to each room in the building.
     * Goes through the array and adds a single occupant to the 
     * room.
     */
    public void incrementAll()
    {
        for(int i : personsPerRoom)
            i++;
    }
    /**Returns the occupancy of the room with the highest occupancy.
     * Examines the array and compares the current maximum occupancy to 
     * that of the current room occupancy; if the occupancy is greater it 
     * will set that occupancy to be the new maximum occupancy.
     * @return The occupancy of the most occupied room in the house.
     */
    public int maxOccupancy()
    {
        int max = 0;
        for(int i : personsPerRoom)
        {
            if(i > max)
                max = i;
        }
        return max;
    }
}
