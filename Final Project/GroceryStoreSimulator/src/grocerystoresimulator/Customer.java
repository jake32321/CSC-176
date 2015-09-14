package grocerystoresimulator;

import java.util.Random;

/**
 *
 * @authors Sean and Jacob
 */
public class Customer implements Comparable{
    
    private int numOfItems;
    private String name;
    /**
     * Used to create a new customer object whenever a new customer enters
     * the store.
     */
    public Customer()
    {
        Random first = new Random();
        Random last = new Random();
        Random items = new Random();
        Random chance = new Random();
        
        String[] firstNames = {"Norah", "Roderick", "Alec", "Sean", "Jacob", 
            "Delia", "Emmet", "Colbert", "Katherine", "Lily"};
        
        String[] lastNames = {"Smith", "Gavelis", "Vinal", "Flanagan", "Tate", 
            "Henderson", "Hawthorne", "Ayers", "Sperling", "Morrell"};
        
        if( (chance.nextInt(100) + 1) <= 30)
            numOfItems = items.nextInt(30) + 6;
        else
            numOfItems = items.nextInt(10) + 1;
        
        
        name = firstNames[first.nextInt(10)] +" "+ lastNames[last.nextInt(10)];
    }
    /**
     * Gets the number of items a customer wants.
     * @return The number of items.
     */
    public int getItems()
    {
        return numOfItems;
    }
    /**
     * Gets the name of a specific customer.
     * @return The name of the customer.
     */
    public String getName()
    {
        return name;
    }
    /**
     * Retrieves all basic info about a customer when called.
     * @return The customer's basic information.
     */
    public String toString()
    {
        return name + " wanting " + numOfItems + " item(s)";
    }
    /**
     * Method for comparing customers to see who has a higher priority.
     * @param other
     * @return 
     */
    public int compareTo(Object other)
    {
        Customer otherCustomer = (Customer) other;
        return (numOfItems - otherCustomer.getItems());
    }
}