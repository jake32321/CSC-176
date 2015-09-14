package grocerystoresimulator;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.*;


/**
 *
 * @author Sean and Jacob
 */
public class SimulatorGUI extends JFrame {
    
    public final int WIDTH = 600, HEIGHT = 370;
    public final String TITLE_PHRASE = "Grocery Store Simulator";
    CheckOut storeLine = new CheckOut();
    private JTextArea roster;
    private int expressCnt = 0, standardCnt = 0;
    private JButton enter, toLine, process, showShopper, showCheckout;
    private int custCycleCount = 0;
    SoundClip backgroundSong;
    /**
     * Creates the entire GUI for the application.
     */
    public SimulatorGUI()
    {
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE_PHRASE);
        setLayout(new GridLayout(1,1));
        setResizable(false);
        
        add(makeButtonsPanel());
        add(makeOutputPanel());
        
        try
        {
            backgroundSong = new SoundClip("Annoying Shop Song.wav");
            backgroundSong.loopCont();
        }
        catch(UnsupportedAudioFileException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     * Responsible for creating the output panel for the GUI.
     * @return The output panel.
     */
    private JPanel makeOutputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0,0,0,0));
        
        roster = new JTextArea(20,25);
        roster.setWrapStyleWord(true);
        roster.setLineWrap(true);
        roster.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(roster);
        
        panel.add(scroll);

        return panel;
    }
    /**
     * Responsible for making the buttons panel for the GUI.
     * @return The buttons panel.
     */
    private JPanel makeButtonsPanel()
    {
        JPanel panel = new JPanel();
        
        panel.setBorder(new EtchedBorder());
        panel.setBackground(Color.WHITE);
        ImageIcon register = new ImageIcon("Cash_Register.png");
        ImageIcon checkout = new ImageIcon("counter.png");
        ImageIcon customer = new ImageIcon("card-address.png");
        ImageIcon cart = new ImageIcon("shopping-cart.png");
        ImageIcon cashier = new ImageIcon("line.png");

        enter = new JButton(cart);
        toLine = new JButton(cashier);
        process = new JButton(register);
        showShopper = new JButton(customer);
        showCheckout = new JButton(checkout);
        
        process.setToolTipText("PROCESS CUSTOMER");
        process.setBorder(new EmptyBorder(0,0,0,0));
        process.addActionListener(new ProcessButtonListener());
        
        showShopper.setToolTipText("SHOW SHOPPERS");
        showShopper.setBorder(new EmptyBorder(0,0,0,0));
        showShopper.addActionListener(new ShopperButtonListener());
        
        showCheckout.setToolTipText("SHOW CHECKOUT LINES");
        showCheckout.setBorder(new EmptyBorder(0,0,0,0));
        showCheckout.addActionListener(new CheckoutButtonListener());
        
        enter.setToolTipText("CUSTOMER ENTER");
        enter.setBorder(new EmptyBorder(0,0,0,0));
        enter.addActionListener(new EnterButtonListener());
        
        toLine.setToolTipText("CUSTOMER TO LINE");
        toLine.setBorder(new EmptyBorder(0,0,0,0));
        toLine.addActionListener(new LineButtonListener());
        
        panel.add(enter);
        panel.add(toLine);
        panel.add(showShopper);
        panel.add(showCheckout);
        panel.add(process);
        
        ImageIcon image = new ImageIcon("store.png");
        JLabel label = new JLabel("",image,JLabel.CENTER);
        label.setBorder(new LineBorder(Color.BLACK));
        panel.add(label, BorderLayout.SOUTH);

        return panel;
    }
    /**
     * Action Listener used for processing a customer when the button it is 
     * added to is pressed.
     */
    class ProcessButtonListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                SoundClip clip = new SoundClip("till-with-bell.wav");
                clip.play();
            }
            catch(UnsupportedAudioFileException | LineUnavailableException e) 
            {
                e.printStackTrace();
            }
            if(custCycleCount < 2 && storeLine.expressLength()>0)
            {
                roster.append("\nCustomer: "+storeLine.peekExpress()
                        +" has checked out.\n");
                storeLine.removeFromExpress();
                custCycleCount++;
                expressCnt++;
                if(storeLine.standardLength() == 0)
                    custCycleCount = 0;
                roster.append("\nCustomers checked out in "
                        + "express line: "+expressCnt+"\n");
            }
            else if(storeLine.standardLength() > 0)
            {
                roster.append("\nCustomer: " + storeLine.peekStandard()
                        + " has checked out.\n");
                storeLine.removeFromStandard();
                custCycleCount = 0;
                standardCnt++;          
                roster.append("\nCustomers checked out in "
                        + "standard line: " + standardCnt + "\n");
            }
            else
            {
                roster.append("\nThere are no customers in"
                        + " either line.\n");
            }
        }
    }
    /**
     * Action Listener used for adding a customer to the store when the button 
     * it is added to is pressed.
     */
    class EnterButtonListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent ae)
        {
        try
        {
            SoundClip clip = new SoundClip("button-press.wav");
            clip.play();
        }
        catch(UnsupportedAudioFileException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
            Customer customer = new Customer();
            storeLine.add(customer);
            roster.append("\nCustomer: " + customer.getName()
                    +" entered wanting " + customer.getItems()+" items.\n");
        }      
    }
    /**
     * Action Listener that moves a customer to a specific lane when the 
     * button it is added to is pressed.
     */
    class LineButtonListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                SoundClip clip = new SoundClip("button-press.wav");
                clip.play();
            }
            catch(UnsupportedAudioFileException | LineUnavailableException e) 
            {
                e.printStackTrace();
            }
            if(storeLine.peekShopping() != null)
            {
                storeLine.moveToCheckOut();
                roster.append(storeLine.getLine());
            }
            else
                roster.append("\nThere is no one shopping.\n");
        }
    }
    /**
     * Action Listener that displays the customers still shopping when
     * the button it is added to is pressed.
     */
    class ShopperButtonListener implements ActionListener
    {  
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                SoundClip clip = new SoundClip("button-press.wav");
                clip.play();
            }
            catch(UnsupportedAudioFileException | LineUnavailableException e) 
            {
                e.printStackTrace();
            }
            roster.append("\nCustomers Shopping: \n"
                    +storeLine.showShopping()+"\n");
        }
    }
    /**
     * Action Listener that displays the customers occupying each checkout
     * lane when the button it is added to is pressed.
     */
    class CheckoutButtonListener implements ActionListener
    {  
      public void actionPerformed(ActionEvent ae)
       {
            try
            {
                SoundClip clip = new SoundClip("button-press.wav");
                clip.play();
            }
            catch(UnsupportedAudioFileException | LineUnavailableException e) 
            {
                e.printStackTrace();
            }
            roster.append("\nExpress: "+storeLine.showExpress()+"\n");
            roster.append("Standard: "+storeLine.showStandard()+"\n");
        }               
    }
}
