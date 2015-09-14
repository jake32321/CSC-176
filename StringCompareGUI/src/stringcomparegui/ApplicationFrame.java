/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringcomparegui;

/**
 *
 * @author Jacob Reed
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class ApplicationFrame extends JFrame
{
    public final int WIDTH = 600, HEIGHT = 200;
    public final String TITLE_PHRASE = "My Cool Application";

    private JTextField input1, input2, output;
    private JButton button1;

    public ApplicationFrame()
    {
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE_PHRASE);
        setLayout(new GridLayout(1,3));

        add(makeInputPanel());
        add(makeOutputPanel());
        add(makeButtonsPanel());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel makeInputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        input1 = new JTextField(8);
        input2 = new JTextField(8);
        panel.add(input1);
        panel.add(input2);

        return panel;
    }
      
    private JPanel makeOutputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        output = new JTextField(15);
        output.setEditable(false);
        panel.add(output);

        return panel;
    }

    private JPanel makeButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(new EtchedBorder());

        
        button1 = new JButton("PRESS HERE");
        ActionListener buttonListener = new ButtonListener();
        button1.addActionListener(buttonListener);
        panel.add(button1);

        return panel;
    }

    // Place any inner class definitions below this line
    
    private String retrieveData1()
    {
        String a = input1.getText();
        if(a.length()==0)
            throw new ApplicationException("First input empty");
        else 
            return a;
    }
    
    private String retrieveData2()
    {
        String b = input2.getText();
         if(b.length()==0)
            throw new ApplicationException("Second input empty");
        else 
            return b;
    }
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String a = retrieveData1();
                String b = retrieveData2();
                String result;
                
                if(a.compareTo(b)>0)
                result = a+" comes after "+b;
            else if(a.compareTo(b)<0)
                result = b+" comes after "+a;
            else 
                result = a+" is the same word as "+b;
            
            output.setText(result);
            }
            catch (ApplicationException ex)
            {
                output.setText(ex.getMessage());
            }
        }
    }
}
