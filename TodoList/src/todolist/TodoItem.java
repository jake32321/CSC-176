/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolist;
/**
 *
 * @author Jacob Reed
 */
public class TodoItem {
    
    private static int priorityLvl;
    private static String description;
    
    public TodoItem(int priority, String item)
    {
        description = item;
        priorityLvl = priority;
    }
}
