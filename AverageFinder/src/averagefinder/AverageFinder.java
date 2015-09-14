/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package averagefinder;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jacob Reed
 */
public class AverageFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        double value, total = 0;
        int numOfValues = 0;
        
        while(numOfValues < 6)
        {
            try
            {
                System.out.println("Please enter a real number...");
                value = in.nextDouble();
                total = total+value;
                numOfValues++;
            }
            catch(InputMismatchException ex)
            {
                System.out.println("INVALID INPUT PARAM.");
                in.next();
            }
        }
        
        System.out.println("The average of the numbers i: "+total/numOfValues);
        
    }
}
