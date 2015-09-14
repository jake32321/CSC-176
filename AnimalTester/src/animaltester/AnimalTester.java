package animaltester;

import java.util.ArrayList;

/**
 * 
 * @author Jacob Reed
 */
public class AnimalTester {

    public static void main(String[] args) {

        // --------------- Testing the Features of the Base Class  ----------
        Animal fox = new Animal(12.5, 2);
        Animal zebra = new Animal(65.0);

        System.out.println("The fox is: " + fox.toString());
        System.out.println("The zebra is: " + zebra);

        zebra.addYears(2);
        zebra.addWeight(240.0);
        System.out.println("Some time later, the zebra is:");
        System.out.println(zebra);

        // -------- Testing The Features of the Derived Class  -----------
        
        //Creates a "flamingo" Bird Object and calls some of its methods
        Bird flamingo = new Bird(7.0, 20.0);
        System.out.println("Flamingo age: "+flamingo.getAge());
        System.out.println("Flamingo span: "+flamingo.getWingspan());
        flamingo.addYears(4);
        System.out.println(flamingo);
        
        //Creates a Bird Object named "fourth" 
        Animal fourth = new Bird(3.5, 10);
        System.out.println("The fourth animal has these stats: ");
        System.out.println(fourth);
        System.out.println(fourth.getWeight());
        
        //Creates a collection of Animals.
        ArrayList<Animal> zoo = new ArrayList<>();
        zoo.add(new Animal(2.5));
        zoo.add(new Bird(7.5, 15.5));
        System.out.println("Here are the zoo's residents: ");
        System.out.println(zoo);
        
        //Creates a new "fox" Animal object to be compared.
        Animal fox2 = new Animal(12.5, 2);
        Animal fox3 = fox;
        
        /*
         * Code should not present any output since the objects are not
         * the same object at the same place in the memory.
         */
        if(fox.equals(fox2));
            System.out.println("Objects are equal!");
        
        //Will produce output since the statement returns true.
        if(fox.equals(fox3))
            System.out.println("Objects are equal!");
            
    }
}
