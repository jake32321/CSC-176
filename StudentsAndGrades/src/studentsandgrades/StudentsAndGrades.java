package studentsandgrades;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Jake Reed
 */
public class StudentsAndGrades {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Map<String, String> students = new TreeMap<>();
        int count = 0;
        
        do
        {
            System.out.println("Which would you like to do?\n");
            System.out.println("Remove\nAdd\nPrint Students\n");
            String usrAns = in.next();
            
            if(usrAns.toUpperCase().equals("ADD"))
            {
                System.out.println("What is the student's name?");
                String name = in.next();
                System.out.println("\nWhat was their grade?");
                String grade = in.next();
                students.put(name, grade);
            }
            
            if(usrAns.toUpperCase().equals("REMOVE"))
            {
                System.out.println("Which student do you wish to remove?");
                String name = in.next();
                students.remove(name);
                System.out.println("\nStudent has been removed...\n");
            }
            
            if(usrAns.toUpperCase().equals("PRINT"))
            {
                for(String key : students.keySet())
                {
                    System.out.println(key+": "+students.get(key));
                }
                System.out.println("Students have been listed...");
            }
            
            else
            {
                System.err.println("ERROR:\n");
                System.out.println("Invalid input!");
                count++;
                if(count == 5)
                    System.out.println("Program terminating...");
            }
        }while(count < 6);
        
    }
    
}
