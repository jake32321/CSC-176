/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zarkaniantester;

import java.util.Scanner;

/**
 *
 * @author Jacob Reed
 */
public class ZarkanianTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        
        try
        {
            System.out.println("What is the name of the new Zarkaninan child?");
            String name = in.next();
            //Has the potential to throw an exception. (RuntimeException)
            Zarkanian child = new Zarkanian(name);
            System.out.println("Child created sucessfully: "+child);
        }
        catch(NameTooLongException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Zarkanian names can have only 5 or fewer characters in their name.");
        }
        catch(InvalidCharacterException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Zarchanians cannot have the letter 'R' in their name.");
        }
        finally
        {
            System.out.println("Program run has finished...");
        }
        
    }
    
}
