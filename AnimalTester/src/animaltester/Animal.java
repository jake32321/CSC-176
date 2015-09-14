package animaltester;
/** A class for representing information about living animals.
 * Each animal has a weight (in lbs) and an age (in years).
 * @author Jacob Reed
 */
public class Animal
{
    private double weightInLbs;
    private int ageInYrs;

    /** Creates a new Animal with specified weight and age.
     * @param weight the number of lbs that the animal weighs
     * @param age the number of years in the animal's age
     */
    public Animal(double weight, int age)
    {
        weightInLbs = weight;
        ageInYrs = age;
    }

    /** Creates a newborn Animal with a specified weight.
     * Since the animal is a newborn, it begins with an age of 0 yrs.
     * @param birthWt the number of lbs the animal weighs at birth
     */
    public Animal(double birthWt)
    {
        weightInLbs = birthWt;
    }

    /** Returns the current weight of the animal, in lbs.
     * @return the current weight of the animal
     */
    public double getWeight()
    {
        return weightInLbs;
    }

    /** Returns the current age of the animal, in yrs.
     * @return the current age of the animal
     */
    public int getAge()
    {
        return ageInYrs;
    }

    /** Modifies the weight of the animal.
     * @param increaseAmt the number of lbs that will be added to the
     * weight of the animal. Note: The value of this parameter can be
     * negative; if so, then the weight of the animal becomes decreased.
     */
    public void addWeight(double increaseAmt)
    {
        weightInLbs = weightInLbs + increaseAmt;
    }

    /** Modifies the age of the animal.
     * @param numYears the number of years that will be added to the
     * age of the animal. Note: This method currently permits a negative
     * value for this parameter. If numYrs is negative, the age of the
     * animal will be reduced.
     */
    public void addYears(int numYears)
    {
        ageInYrs = ageInYrs + numYears;
    }

    /** Returns a "stringified" version of the animal.
     * @return A string is returned that begins with the name of the
     * class that the animal belongs to, followed by its weight and age
     * contained inside of brackets.
     */
    public String toString()
    {
        return getClass().getName() + "[Weight: " + weightInLbs
               + " lbs , Age: " + ageInYrs + " yrs]";
    }

}
