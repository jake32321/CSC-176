package guilabpart1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Jacob Reed
 */
public class QpaFrame extends JFrame {

    private JTextField gradeIn, qpaOut, message;
    private JRadioButton advanced, standard;
    private JButton processor;
    private Integer qualityPts, classCount;
    
    public QpaFrame()
    {
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        qualityPts = 0;
        classCount = 0;

        add(makeInputPanel());
        add(makeButtonPanel());
        add(makeOutputPanel());
        
        processor = new JButton("Process Grade");
        processor.addActionListener(new ButtonListener());
        add(processor);
        
        setLayout(new GridLayout(2,2));
        
        setVisible(true);
    }

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          String lGrade = gradeIn.getText();
          
          qualityPts = qualityPts + letterToNumGrade(lGrade);
          if(advanced.isSelected())
              qualityPts++;
          classCount++;
          
          qpaOut.setText(""+(qualityPts/(1.0*classCount)));
          message.setText(lGrade + " Processed");
        }
    }

    private JPanel makeInputPanel()
    {
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder());
        panel.add(new JLabel("Class Grade"));
        gradeIn = new JTextField(5);
        panel.add(gradeIn);
        return panel;
    }

    private JPanel makeButtonPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.setBorder(new EtchedBorder());
        
        advanced = new JRadioButton("Advanced Class");
        standard = new JRadioButton("Standard Class");
        panel.add(advanced);
        panel.add(standard);
        
        ButtonGroup levels = new ButtonGroup();
        levels.add(advanced);
        levels.add(standard);
        standard.setSelected(true);

        return panel;
    }

    private JPanel makeOutputPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.setBorder(new EtchedBorder());

        JPanel qpaOutput = new JPanel();
        qpaOutput.add(new JLabel("Student QPA"));
        qpaOut = new JTextField(8);
        qpaOutput.add(qpaOut);
        panel.add(qpaOutput);

        JPanel response = new JPanel();
        message = new JTextField(12);
        response.add(message);
        panel.add(response);

        return panel;
    }
    
    private int letterToNumGrade(String lGrade)
    {
        if (lGrade.equalsIgnoreCase("A"))
            return 4;
        else if (lGrade.equalsIgnoreCase("B"))
            return 3;
        else if (lGrade.equalsIgnoreCase("C"))
            return 2;
        else if (lGrade.equalsIgnoreCase("D"))
            return 1;
        else
            return 0;
    }
    
}