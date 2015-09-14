package integerexceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jacob Reed
 */
public class IntegerExceptionHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int count = 0;
        int invalidResp = 0;
        int validResp = 0;
        int sum = 0;
        int resp;
        Scanner prompt = new Scanner(System.in);
        
        while(count < 5)
        {
            try
            {
                System.out.print("Please enter an integer...\n");
                resp = prompt.nextInt();
                validResp++;
                sum = sum + resp;
            }
            catch(InputMismatchException ex)
            {
                invalidResp++;
                System.out.println("The input: "+prompt.next()+
                        ", is not valid");
            }
            count++;
        }
        System.out.println("There were "+invalidResp+" invalid inputs given \n"
                + "There were "+validResp+" valid inputs given"
                + "\nThe sum is: "+sum);
    }
}

