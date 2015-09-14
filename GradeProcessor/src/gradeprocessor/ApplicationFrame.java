/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gradeprocessor;

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
    public final int WIDTH = 600, HEIGHT = 100;
    public final String TITLE_PHRASE = "Grade Processor";

    private JTextField input1, output;
    private JRadioButton radio1, radio2, radio3;
    private JCheckBox checker;
    private JButton button1, button2;
    private Student student;

    public ApplicationFrame()
    {
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE_PHRASE);
        setLayout(new GridLayout(1,3));
        student = new Student();

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
        panel.add(new JLabel("Score (0-100): "));
        input1 = new JTextField(8);
        panel.add(input1);

        return panel;
    }

    private JPanel makeOutputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.add(new JLabel("Test Average: "));
        output = new JTextField(8);
        output.setText(""+student.getAvg());
        output.setEditable(false);
        panel.add(output);

        return panel;
    }

    private JPanel makeButtonsPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(new EtchedBorder());

        button1 = new JButton("Process Grade");
        button1.addActionListener(new ButtonListener());
        panel.add(button1);

        return panel;
    }

    // Place any inner class definitions below this line
    class ButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            String input = input1.getText();
            Integer inNum = Integer.parseInt(input);
            try
            {
                student.processGrade(inNum);
                output.setText(""+student.getAvg());
            }
            catch(RuntimeException except)
            {
                System.out.println(except.getMessage());
            }
        }
    }
}