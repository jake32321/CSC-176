/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convertwhileproper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Jacob Reed
 */
public class ConvertFrame extends JFrame{
    
    private String outText, str1 = "GEOMETRY", str2 = "TRIGONOMETRY";
    private JPanel inPanel, outPanel, buttonPanel, radioPanel;
    private JTextField in, out;
    private JRadioButton upper, lower, normal;
    private ButtonGroup group;
    private JButton process;
    
    public ConvertFrame()
    {
        setTitle("Convert While Proper");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Adds the methods to create the various panels.
        add(createInputPanel());
        add(createOutputPanel());
        add(createRadioButtonPanel());
        add(createButtonPanel());
        setLayout(new GridLayout(2,2));
        //Makes the frame visible.
        setVisible(true);
    }
    
    public JPanel createInputPanel()
    {
        inPanel = new JPanel();
        inPanel.add(new JLabel("Word Input"));
        in = new JTextField(8);
        inPanel.add(in);
        return inPanel;
    }
    
    public JPanel createOutputPanel()
    {
        outPanel = new JPanel();
        outPanel.add(new JLabel("Output"));
        out = new JTextField(8);
        out.setEditable(false);
        outPanel.add(out);
        return outPanel;
    }
    
    public JPanel createRadioButtonPanel()
    {
        radioPanel = new JPanel();
        group = new ButtonGroup();
        upper = new JRadioButton("Upper Case");
        lower = new JRadioButton("Lower Case");
        normal = new JRadioButton("Unaltered");
        //Adds the various listeners to the radio buttons.
        upper.addActionListener(new UpperListener());
        lower.addActionListener(new LowerListener());
        normal.addActionListener(new UnalteredListener());
        //Adds the radio buttons to a group.
        group.add(upper);
        group.add(lower);
        group.add(normal);
        //Adds the radio buttons to the panel.
        radioPanel.add(upper);
        radioPanel.add(lower);
        radioPanel.add(normal);
        //Returns the panel.
        return radioPanel;
    }
    
    public JPanel createButtonPanel()
    {
        buttonPanel = new JPanel();
        process = new JButton("PROCESS");
        //Adds the right action listener to the button.
        process.addActionListener(new ButtonListener());
        //Adds the button to the panel.
        buttonPanel.add(process);
        //Returns the panel.
        return buttonPanel;
    }
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            /*
            Make sure that you set the input and the text it is being
            compared to as being upper case. Without this addition the 
            specific radio buttons will not work properly.
            */
            if(outText.toUpperCase().compareTo(str1) > 0 &&
                    outText.toUpperCase().compareTo(str2) < 0)
            {
                out.setText("");
                out.setText(outText);
            }
            else
            {
                out.setText("ERROR!");
            }
        }
    }
    
    class UpperListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Sets the output text to show an upper case version of input.
            outText = in.getText().toUpperCase(); 
        }
    }
    
    class LowerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Sets the output text to show a lower case version of input.
            outText = in.getText().toLowerCase();
        }
    }
    
    class UnalteredListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Sets the output text to the input text.
            outText = in.getText();
        }
    }
}
