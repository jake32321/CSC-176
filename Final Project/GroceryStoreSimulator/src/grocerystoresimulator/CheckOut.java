package grocerystoresimulator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Sean and Jacob
 */
public class CheckOut {
    
    PriorityQueue<Customer> currentlyShopping = new PriorityQueue<>();
    Queue<Customer> expressLine = new LinkedList<>();
    Queue<Customer> standardLine = new LinkedList<>();
    private int express, standard, expressCustomers, standardCustomers;
    private boolean expressIsEmpty;
    private boolean standardIsEmpty;
    private String whichLineOut;
    /**
     * Creates a checkout object that can be used for 
     * manipulating store lines.
     */
    public CheckOut()
    {
        express = 0;
        standard = 0;
        expressCustomers = 0;
        standardCustomers = 0;
        expressIsEmpty = true;
        standardIsEmpty = true;
        
    }
    /**
     * Adds a customer to the store to shop until they are moved to a 
     * checkout line based on their priority in the queue.
     * @param name The customer added to the store.
     */
    public void add(Customer name)
    {
        currentlyShopping.add(name);
    }
    /**
     * Moves a customer to a checkout line based on the items they have and
     * or if the lane is empty or not.
     * @throws RuntimeException Thrown if the customer does not fit any of 
     * the criteria for being moved to a line.
     */
    public void moveToCheckOut() throws RuntimeException
    {
        if(currentlyShopping.peek().getItems() > 8)
        {
            if(expressIsEmpty)
            {
                whichLineOut = "\n"+currentlyShopping.peek()
                        +" moved to the express lane.\n";
                expressLine.add(currentlyShopping.remove());
                express++;
                expressIsEmpty = false;
            }
            else
            {
                whichLineOut = "\n"+currentlyShopping.peek()
                        +" moved to the standard lane.\n";
                standardLine.add(currentlyShopping.remove());
                standard++;
                standardIsEmpty = false;
            }
        }
        else if(currentlyShopping.peek().getItems() <= 8)
        {
            if(standardIsEmpty)
            {
                if(!expressIsEmpty)
                {
                    whichLineOut = "\n"+currentlyShopping.peek()
                            +" moved to the standard lane.\n";
                    standardLine.add(currentlyShopping.remove());
                    standard++;
                    standardIsEmpty = false;
                }
                else
                {
                    whichLineOut = "\n"+currentlyShopping.peek()
                            +" moved to the express lane.\n";
                    expressLine.add(currentlyShopping.remove());
                    express++;
                    expressIsEmpty = false;
                }
            }
            else
            {
                whichLineOut = "\n"+currentlyShopping.peek()
                        +" moved to the express lane.\n";
                expressLine.add(currentlyShopping.remove());
                express++;
                expressIsEmpty = false;
            }
        }
        else
            throw new RuntimeException("There is no one currently shopping");
    }
    /**
     * Removes a customer from the express lane after they 
     * have "checked out".
     */
    public void removeFromExpress()
    {
        expressLine.remove();
        express--;
        expressCustomers++;
        if(expressLine == null)
            expressIsEmpty = true;
    }
    /**
     * Removes a customer from the standard lane after they 
     * have "checked out".
     */
    public void removeFromStandard()
    {
        standardLine.remove();
        standard--;
        standardCustomers++;
        if(standardLine == null)
            standardIsEmpty = true;
    }
    /**
     * Shows who is currently in the express lane and how many items 
     * they have.
     * @return The names and the number of items of the customers 
     * currently occupying the lane.
     */
    public String showExpress()
    {
        if(expressLine.isEmpty())
            return "\nEMPTY";
        else
        {
            String exp = "";
            ArrayList<String> s = new ArrayList<>();
            for(Customer customer : expressLine)
            {
                s.add(customer.toString());
            }
            for(String customer : s)
            {
                exp = exp +"\n"+customer;
            }
            return exp;
        }
    }
    /**
     * Shows who is currently in the standard lane and how many 
     * items they have.
     * @return The names of the customers and the number of items they have
     * that currently occupy that lane.
     */
    public String showStandard()
    {
        if(standardLine.isEmpty())
            return "\nEMPTY";
        else
        {
            String sta = "";
            ArrayList<String> s = new ArrayList<>();
            for(Customer customer : standardLine)
            {
                s.add(customer.toString());
            }
            for(String customer : s)
            {
                sta = sta +"\n"+customer;
            }
            return sta;
        }
    }
    /**
     * Shows the customers still shopping in the store and how many items 
     * they are shopping for.
     * @return The customers still shopping and how many items they want. 
     */
    public String showShopping()
    {
        if(currentlyShopping.isEmpty())
            return "EMPTY";
        else
        {
            String sho = "";
            ArrayList<String> s = new ArrayList<>();
            for(Customer customer : currentlyShopping)
            {
                s.add(customer.toString());
            }
            for(String customer : s)
            {
                sho = sho + customer + "\n";
            }
            return sho;
        }
    }
    /**
     * Shows how long the express lane is.
     * @return The length of the express lane in integer form.
     */
    public int expressLength()
    {
        return express;
    }
    /**
     * Shows how long the standard lane is.
     * @return The length of the standard lane in integer form.
     */
    public int standardLength()
    {            
        return standard;
    }
    /**
     * Gets the highest priority/first customer in the currently 
     * shopping queue.
     * @return The name and number of items the customer wants.
     */
    public Customer peekShopping()
    {
        return currentlyShopping.peek();
    }
    /**
     * Gets the highest priority/first customer in the express lane queue.
     * @return The name and number of items the customer wants.
     */
    public Customer peekExpress()
    {
        return expressLine.peek();
    }
    /**
     * Gets the highest priority/first customer in the standard lane.
     * @return The name and number of items the customer wants.
     */
    public Customer peekStandard()
    {
        return standardLine.peek();
    }
    /**
     * Gets the string regarding who was moved to which line depending on
     * the moveToCheckout() method.
     * @return The String saying who was moved to which lane.
     */
    public String getLine()
    {
        return whichLineOut;
    }
}

