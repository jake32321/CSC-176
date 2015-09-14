/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolist;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Jacob Reed
 */
public class TodoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PriorityQueue<TodoItem> todoList1 = new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        String usrAns;
        
        do
        {
            System.out.println("Choose an option...");
            System.out.println("\nAdd\nNext\nQuit\n");
            usrAns = in.next();
            
            if(usrAns.toUpperCase().equals("ADD"))
            {
                System.out.println("Enter the priority...");
                int priority = in.nextInt();
                System.out.println("Enter a description...");
                String description = in.next();
                TodoItem newItem = new TodoItem(priority, description);
                todoList1.add(newItem);
            }
            
            if(usrAns.toUpperCase().equals("NEXT"))
            {
                System.out.println("On to the next item...");
                todoList1.remove();
            }
            
            else
            {
                System.err.println("ERROR:");
                System.out.println("Invalid!");
            }
        }while(!usrAns.toUpperCase().equals("QUIT"));
        
    }
    
}
