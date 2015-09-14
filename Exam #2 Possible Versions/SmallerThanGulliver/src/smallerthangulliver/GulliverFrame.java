/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smallerthangulliver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GulliverFrame extends JFrame
{
    public final int WIDTH = 400, HEIGHT = 400;
    public final String TITLE_PHRASE = "My Cool Application";

    private Timer time = new Timer(5000, new TimerListener());
    private JTextField input1, output;
    private JCheckBox checker;
    private int count = 0;
    private final String text = "GULLIVER";

    public GulliverFrame()
    {
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE_PHRASE);
        setLayout(new GridLayout(3,1));
        
        time.start();
        add(makeInputPanel());
        add(makeOutputPanel());
        add(makeOptionsPanel());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    private JPanel makeInputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.add(new JLabel("Input Word"));
        input1 = new JTextField(8);
        panel.add(input1);

        return panel;
    }
    
    private JPanel makeOutputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.add(new JLabel("Running Total"));
        output = new JTextField(8);
        output.setEditable(false);
        panel.add(output);

        return panel;
    }

    private JPanel makeOptionsPanel()
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Disregard"));
        checker = new JCheckBox();
        panel.add(checker);
        return panel;
    }
    
    // Place any inner class definitions below this line
   
    
    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String wrd = input1.getText().toUpperCase();
            if(wrd.compareTo(text)<0)
            {
                if(!checker.isSelected())
                {
                    count++;
                    output.setText(""+count);
                }
            }
        }
    }
    
}

