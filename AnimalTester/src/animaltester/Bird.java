/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animaltester;

/**
 * Extends Animal class.
 * @author Jacob Reed
 */
public class Bird extends Animal{
    
    private double wingspanInches;
    /**
     * Creates a new Bird Object (existing)
     * @param weight the current weight of the bird.
     * @param age the current age of the bird.
     * @param span the current wingspan of the bird.
     */
    public Bird(double weight, int age, double span)
    {
        super(weight, age);
        wingspanInches = span;
    }
    /**
     * Creates a new Bird Object (newborn)
     * @param weight the newborn weight.
     * @param span the newborn wingspan.
     */
    public Bird(double weight, double span)
    {
        super(weight);
        wingspanInches = span;
    }
    /**
     * Gets the wingspan of a Bird Object.
     * @return the wingspan.
     */
    public double getWingspan()
    {
        return wingspanInches;
    }
    /**
     * Returns the information from the super class plus the wingspan of 
     * a Bird Object.
     * @return the super class info along with the wingspan.
     */
    @Override
    public String toString()
    {
        return super.toString() + "[Wingspan: "+wingspanInches+" in.]";
    }
}
