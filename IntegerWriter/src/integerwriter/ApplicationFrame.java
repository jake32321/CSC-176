/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integerwriter;

/**
 *
 * @author Jacob Reed
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.border.*;

public class ApplicationFrame extends JFrame
{
    public final int WIDTH = 600, HEIGHT = 100;
    public final String TITLE_PHRASE = "Integer File Writer";

    private JTextField input1, input2, input3, output;
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
        input3 = new JTextField(15);
        panel.add(input1);
        panel.add(input2);
        panel.add(input3);

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

        button1 = new JButton("Write To File");
        button1.addActionListener(new ButtonListener());
        panel.add(button1);

        return panel;
    }

    // Place any inner class definitions below this line

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Integer start = Integer.parseInt(input1.getText());
            Integer end = Integer.parseInt(input2.getText());
            String fileName = input3.getText();
            
            try
            {
                PrintWriter in = new PrintWriter(fileName);
            
                for(int i = start; i <= end; i++)
                {
                    in.println(i);
                }
                in.close();
                output.setText("Data written to file: "+fileName);
            }
            catch(FileNotFoundException ex)
            {
                output.setText(ex.getMessage());
            }
        }
    }
}