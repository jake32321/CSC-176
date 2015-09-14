/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package namebox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jacob Reed
 */
public class NameBox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame box = new JFrame("Box Tester");
        box.setSize(300,300);
        
        JPanel panel = new JPanel();
        JButton button = new JButton("Press Me!");
        
        
        final JTextField field = new JTextField();
        class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                field.setText("Me");
            }
        }
        
        field.setText("Jake Reed");
        field.setEditable(false);
        panel.add(field);
        panel.add(button);
        box.add(panel);
        
        button.addActionListener(new Listener());
        
        box.setVisible(true);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
