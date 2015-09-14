package pairofmodifiers;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.lang.model.element.Modifier;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jacob Reed
 */
public class ModifierFrame extends JFrame{
    
    private JTextField modifier1, modifier2;
    private JButton button;
    private final Modifier [] a = Modifier.values();
    private Modifier modOne;
    private Modifier modTwo;
    private JPanel modPanel, colorPanel,buttonPanel;
    
    public ModifierFrame()
    {
        setSize(200,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        setTitle("Pair of Modifiers");
        
        add(createModOnePanel());
        add(createColorPanel());
        add(createButtonPanel());
        
        setVisible(true);
    }
    
    public JPanel createModOnePanel()
    {
        modPanel = new JPanel();
        modifier1 = new JTextField(8);
        modifier1.setEditable(false);
        modPanel.add(new JLabel("Modifier #1"));
        modPanel.add(modifier1);
        modifier2 = new JTextField(8);
        modifier2.setEditable(false);
        modPanel.add(new JLabel("Modifier #2"));
        modPanel.add(modifier2);
        return modPanel;
    }
    
    public JPanel createColorPanel()
    {
        colorPanel = new JPanel();
        return colorPanel;
    }
    
    public JPanel createButtonPanel()
    {
        buttonPanel = new JPanel();
        button = new JButton("GENERATE");
        
        button.addActionListener(new ButtonListener());
        
        buttonPanel.add(button);
        return buttonPanel;
    }
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            modOne = a[(int)(11*Math.random())];
            modTwo =  a[(int)(11*Math.random())];
            modifier1.setText(""+modOne);
            modifier2.setText(""+modTwo);
            if(modOne.compareTo(modTwo)==0)
            {
                colorPanel.setBackground(Color.WHITE);
            }
            else if(modOne.compareTo(modTwo)>0)
            {
                colorPanel.setBackground(Color.GREEN);
            }
            else
            {
                colorPanel.setBackground(Color.BLUE);
            }
        }
    }
    
}
