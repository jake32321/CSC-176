package smallerthangulliver;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Jacob Reed
 */
public class GulliverFrame extends JFrame {
    
    private JPanel inputPanel, outputPanel, boxPanel;
    private JTextField in, out;
    private JCheckBox disregard;
    private final Timer time = new Timer(5000, new TimerListener());
    private int count = 0;
    private final String wrdCmp = "GULLIVER";
    
    public GulliverFrame()
    {
        setSize(200,200);
        setTitle("Smaller Than Gulliver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        
        add(createInputPanel());
        add(createOutputPanel());
        add(createBoxPanel());
        
        time.start();
        
        setVisible(true);
    }
    
    public JPanel createInputPanel()
    {
        inputPanel = new JPanel();
        in = new JTextField(8);
        inputPanel.setBackground(Color.CYAN);
        inputPanel.add(new JLabel("Word Input"));
        inputPanel.add(in);
        return inputPanel;
    }
    
    public JPanel createOutputPanel()
    {
        outputPanel = new JPanel();
        outputPanel.setBackground(Color.GREEN);
        out = new JTextField(8);
        out.setText(""+count);
        out.setEditable(false);
        outputPanel.add(new JLabel("Running Total: "));
        outputPanel.add(out);
        return outputPanel;
    }
    
    public JPanel createBoxPanel()
    {
        boxPanel = new JPanel();
        boxPanel.setBackground(Color.ORANGE);
        disregard = new JCheckBox();
        boxPanel.add(new JLabel("Disregard"));
        boxPanel.add(disregard);
        return boxPanel;
    }
    
    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String word = in.getText().toUpperCase();
            if(disregard.isSelected())
            {
                out.setText(""+count);
            }
            else
            {
                if(word.compareTo(wrdCmp)>0)
                {
                    count++;
                    out.setText(""+count);
                }
            }
        }
    }
    
}
