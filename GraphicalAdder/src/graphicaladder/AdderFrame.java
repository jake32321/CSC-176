/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphicaladder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jacob Reed
 */
public class AdderFrame extends JFrame {
    
    private JTextField one, two, result;
    
    public AdderFrame()
    {
        setSize(600,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Graphical Adder");
        
        //Creates a new panel.
        JPanel panel = new JPanel();
        
        //Creates and adds new field to the panel.
        one = new JTextField(5);
        panel.add(one);
        
        //Adds opperator label to the panel.
        panel.add(new JLabel(" + "));
        
        //Creates and adds new field to the panel.
        two = new JTextField(5);
        panel.add(two);
        
        //Adds new opperator label to the panel.
        panel.add(new JLabel(" = "));
        
        //Creates and adds a new uneditable field to the panel.
        result = new JTextField(5);
        result.setEditable(false);
        panel.add(result);
        
        //Creates a listener for the button to implement.
         class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                String a1 = one.getText();
                String a2 = two.getText();
                
                //Parses them to return them to an integer value
                Integer a = Integer.parseInt(a1);
                Integer b = Integer.parseInt(a2);
                
                String r = ""+(a+b);
                result.setText(r);
            }
        }
        
        //Creates and adds a button to the panel.
        JButton sumFinder = new JButton("Find sum");
        sumFinder.addActionListener(new ButtonListener());
        panel.add(sumFinder);
        
        //Adds finished panel to the JFrame.
        add(panel);
        
       
                
    }
    
}
