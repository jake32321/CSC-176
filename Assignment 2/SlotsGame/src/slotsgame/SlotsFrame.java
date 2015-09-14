package slotsgame;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Jacob Reed
 */
public class SlotsFrame extends JFrame {
    
    private JPanel colorPanelOne, colorPanelTwo, colorPanelThree, 
            radioButtonsPanel, buttonsPanel, outputPanel;
    private JButton go, stop;
    private JRadioButton adv, stan, nov;
    private ButtonGroup group;
    private JTextField output;
    private JMenuBar bar;
    private JMenu speed;
    private JMenuItem faster, slower;
    private final Color[] colors = {Color.RED,Color.BLUE,Color.YELLOW,
        Color.GREEN,Color.ORANGE};
    private int bank = 150;
    private Timer time1 = new Timer(250,new TimerListener1());
    private Timer time2 = new Timer(500,new TimerListener2());
    private Timer time3 = new Timer(750,new TimerListener3());
    private final Random gen = new Random();
        
    public SlotsFrame()
    {
        setSize(600,400);
        setTitle("Slots Game");
        setLayout(new GridLayout(2,3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bar = new JMenuBar();
        
        
        add(createColorPanelOne());
        add(createColorPanelTwo());
        add(createColorPanelThree());
        add(createRadioButtonsPanel());
        add(createButtonsPanel());
        add(createOutputPanel());
        
        setVisible(true);
    }
    
    private JPanel createColorPanelOne()
    {
        colorPanelOne = new JPanel();
        return colorPanelOne;
    }
    
    private JPanel createColorPanelTwo()
    {
        colorPanelTwo = new JPanel();
        return colorPanelTwo;
    }
    
    private JPanel createColorPanelThree()
    {
        colorPanelThree = new JPanel();
        return colorPanelThree;
    }
    
    private JPanel createRadioButtonsPanel()
    {
        radioButtonsPanel = new JPanel();
        adv = new JRadioButton();
        stan = new JRadioButton();
        nov = new JRadioButton();
        group = new ButtonGroup();
        
        radioButtonsPanel.setLayout(new GridLayout(3,1));
        
        group.add(adv);
        group.add(stan);
        group.add(nov);
        
        radioButtonsPanel.add(new JLabel("Advanced"));
        radioButtonsPanel.add(adv);
        radioButtonsPanel.add(new JLabel("Standard"));
        radioButtonsPanel.add(stan);
        radioButtonsPanel.add(new JLabel("Novice"));
        radioButtonsPanel.add(nov);
        
        return radioButtonsPanel;
    }
    
    private JPanel createButtonsPanel()
    {
        go = new JButton("Start");
        stop = new JButton("Stop");
        buttonsPanel = new JPanel();
        
        buttonsPanel.setLayout(new GridLayout(2,1));
        
        go.addActionListener(new StartListener());
        stop.addActionListener(new StopListener());
        
        buttonsPanel.add(go);
        buttonsPanel.add(stop);
        
        return buttonsPanel;
    }
    
    private JPanel createOutputPanel()
    {
        outputPanel = new JPanel();
        outputPanel.add(new JLabel("Bank: $"));
        output = new JTextField(8);
        output.setEditable(false);
        output.setText(""+bank);
        outputPanel.add(output);
        return outputPanel;
    }
    
    class FasterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
    
    class SlowerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
    
    class StartListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            if(bank != 0)
            {
                time1.start();
                time2.start();
                time3.start();
            }
        }
    }
    
    class StopListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            time1.stop();
            time2.stop();
            time3.stop();
            
            if(adv.isSelected())
            {
                if(colorPanelOne.getBackground().equals(Color.GREEN) && 
                        colorPanelTwo.getBackground().equals(Color.GREEN) && 
                        colorPanelThree.getBackground().equals(Color.GREEN))
                {
                    bank = bank+50;
                    output.setText(""+bank);
                }
                if(colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground()) && 
                        colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground()))
                {
                    bank = bank+25;
                    output.setText(""+bank);
                }
                if(colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground())
                        ||colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground())
                        ||colorPanelOne.getBackground().
                                equals(colorPanelThree.getBackground()))
                {
                    bank = bank+15;
                    output.setText(""+bank);
                }
                if(!colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground()) && 
                        !colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground()) && 
                        !colorPanelThree.getBackground().
                                equals(colorPanelOne.getBackground()))
                {
                    bank = bank-30;
                    output.setText(""+bank);
                }
                else
                {
                    bank = bank+5;
                    output.setText(""+bank);
                }
            }
            if(stan.isSelected())
            {
                if(colorPanelOne.getBackground().equals(GREEN) && 
                        colorPanelTwo.getBackground().equals(GREEN) && 
                        colorPanelThree.getBackground().equals(GREEN))
                {
                    bank = bank+100;
                    output.setText(""+bank);
                }
                if(colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground()) && 
                        colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground()))
                {
                    bank = bank+50;
                    output.setText(""+bank);
                }
                if(colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground())
                        ||colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground())
                        ||colorPanelOne.getBackground().
                                equals(colorPanelThree.getBackground()))
                {
                    bank = bank+30;
                    output.setText(""+bank);
                }
                if(!colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground()) && 
                        !colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground()) && 
                        !colorPanelThree.getBackground().
                                equals(colorPanelOne.getBackground()))
                {
                    bank = bank-30;
                    output.setText(""+bank);
                }
                else
                {
                    bank = bank+10;
                    output.setText(""+bank);
                }
            }
            if(nov.isSelected())
            {
                if(colorPanelOne.getBackground().equals(GREEN) && 
                        colorPanelTwo.getBackground().equals(GREEN) && 
                        colorPanelThree.getBackground().equals(GREEN))
                {
                    bank = bank+200;
                    output.setText(""+bank);
                }
                if(colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground()) && 
                        colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground()))
                {
                    bank = bank+100;
                    output.setText(""+bank);
                }
                if(colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground())
                        ||colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground())
                        ||colorPanelOne.getBackground().
                                equals(colorPanelThree.getBackground()))
                {
                    bank = bank+60;
                    output.setText(""+bank);
                }
                if(!colorPanelOne.getBackground().
                        equals(colorPanelTwo.getBackground()) && 
                        !colorPanelTwo.getBackground().
                                equals(colorPanelThree.getBackground()) && 
                        !colorPanelThree.getBackground().
                                equals(colorPanelOne.getBackground()))
                {
                    bank = bank-15;
                    output.setText(""+bank);
                }
                else
                {
                    bank = bank+20;
                    output.setText(""+bank);
                }
            }
        }
    }
    
    class TimerListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int startColor = gen.nextInt(colors.length);
            colorPanelOne.setBackground(colors[startColor]);
            int index = startColor;
            
                colorPanelOne.setBackground(colors[index]);
                index++;
                if(index > 4)
                    index = 0;
            
        }
    }    
    class TimerListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int startColor = gen.nextInt(colors.length);
            colorPanelTwo.setBackground(colors[startColor]);
            int index = startColor;
            
                colorPanelTwo.setBackground(colors[index]);
                index++;
                if(index > 4)
                    index = 0;
            
        }
    }
    
    class TimerListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int startColor = gen.nextInt(colors.length);
            colorPanelThree.setBackground(colors[startColor]);
            int index = startColor;
            colorPanelThree.setBackground(colors[index]);
            index++;
            if(index > 4)
                index = 0;
        }
        
    }
}