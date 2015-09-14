/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sequencer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jacob Reed
 */
public class SequenceFrame extends JFrame {
    
    private JTextField output;
    private JButton button;
    private Timer counter;
    private boolean isAlpha;
    
    public SequenceFrame()
    {
        setSize(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isAlpha = true;
        
        JMenuItem alpha = new JMenuItem("Letters");
        alpha.addActionListener(new AlphaMenuListener());
        JMenuItem num = new JMenuItem("Numbers");
        num.addActionListener(new NumMenuListener());
        
        JMenu type = new JMenu("Type of Sequence");
        type.add(alpha);
        type.add(num);
        
        JMenuBar bar = new JMenuBar();
        bar.add(type);
        setJMenuBar(bar);
        
        setLayout(new GridLayout(1,2));
       
        button = new JButton("Start/Restart");
        button.addActionListener(new ButtonListener());
        output = new JTextField(5);
        output.setText("A");
        output.setEditable(false);
        add(output);
        add(button);
        
        counter = new Timer(1000, new TimerListener());
        
         setVisible(true);
    }
    
    class NumMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            isAlpha = false;
            output.setText("0");
        }
    }
    
    class AlphaMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            isAlpha = true;
            output.setText("A");
        }
    }
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(isAlpha)
            {
                output.setText("A");
            }
            else 
            {
                output.setText("0");
            }
            counter.start();
        }
    }
    
    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String word = output.getText();
            output.setText(nextString(word));
            if(isAlpha)
            {
                output.setText(nextString(word));
            }
            else
            {
                Integer x = Integer.parseInt(word);
                output.setText(""+nextDigit(x));
            }
        }
    }
    
    private int nextDigit(int val)
    {
        return (val +1)%10;
    }
    
    private String nextString(String wd)
    {
        char val = wd.charAt(0);
        int codeVal = ((int) val)+1;
        if (codeVal > 90)
            codeVal = 65;
        return ""+((char) codeVal);
    }
    
}
