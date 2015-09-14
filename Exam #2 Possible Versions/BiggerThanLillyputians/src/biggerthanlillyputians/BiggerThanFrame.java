package biggerthanlillyputians;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jacob Reed
 */
public class BiggerThanFrame extends JFrame{
    
    private final String nonSen = "LILLYPUTIANS";
    private final String caseSen = "Lillyputians";
    private JPanel inputPan, outputPan, boxPan, buttonPan;
    private JTextField in, out;
    private JCheckBox dntCnt;
    private JButton process;
    private int count = 0;
    
    public BiggerThanFrame()
    {
        setTitle("Bigger Than Lillyputians");
        setSize(700,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,4));
        //Adds all of the panels to the frame.
        add(createInputPanel());
        add(createOutputPanel());
        add(createBoxPanel());
        add(createButtonPanel());
        //Makes the frame visible.
        setVisible(true);
    }
    
    public JPanel createInputPanel()
    {
        inputPan = new JPanel();
        in = new JTextField(8);
        inputPan.add(new JLabel("Input Word"));
        inputPan.setBackground(Color.RED);
        inputPan.add(in);
        return inputPan;
    }
    
    public JPanel createOutputPanel()
    {
        outputPan = new JPanel();
        out = new JTextField(8);
        outputPan.add(new JLabel("Running Total: "));
        outputPan.setBackground(Color.YELLOW);
        out.setEditable(false);
        outputPan.add(out);
        return outputPan;
    }
    
    public JPanel createBoxPanel()
    {
        boxPan = new JPanel();
        dntCnt = new JCheckBox();
        boxPan.add(new JLabel("Case Sensitive"));
        boxPan.setBackground(Color.BLUE);
        dntCnt.setSelected(false);
        boxPan.add(dntCnt);
        return boxPan;
    }
    
    public JPanel createButtonPanel()
    {
        buttonPan = new JPanel();
        process = new JButton("PROCESS");
        buttonPan.setBackground(Color.GREEN);
        //Adds the action listener to the button.
        process.addActionListener(new ButtonListener());
        //Adds the button to the panel.
        buttonPan.add(process);
        //Returns the panel.
        return buttonPan;
    }
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(dntCnt.isSelected())
            {
                if(in.getText().compareTo(caseSen)>0)
                {
                    count++;
                    out.setText(""+count);
                }
            }
            else
            {
                if(in.getText().toUpperCase().compareTo(nonSen)>0)
                {
                    count++;
                    out.setText(""+count);
                }
            }
        }
    }
}
