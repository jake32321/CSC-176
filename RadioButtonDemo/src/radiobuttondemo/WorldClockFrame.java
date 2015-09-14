package radiobuttondemo;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.*;

public class WorldClockFrame  extends JFrame {

    private JTextField timeText;
    private JRadioButton central, western;

    private final String EAST_TEXT = "Central US (Chicago)";
    private final String WEST_TEXT = "Western US (Portland)";

    public WorldClockFrame()
    {
        setSize(300,200);
        setTitle("Times Around The World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        JPanel left = new JPanel();
        left.add(new JLabel("Time is: "));
        timeText = new JTextField(8);
        timeText.setText(getCurrentTime(0));
        left.add(timeText);
        left.setBorder(new EtchedBorder());

        JPanel right = new JPanel();
        right.setBackground(Color.YELLOW);
        right.setBorder(new EtchedBorder());
        
        central = new JRadioButton(EAST_TEXT);
        central.setSelected(true);
        central.addActionListener(new RadioListener(central));

        western = new JRadioButton(WEST_TEXT);
        western.addActionListener(new RadioListener(western));

        ButtonGroup zones = new ButtonGroup();
        zones.add(central);
        zones.add(western);
        
        right.add(central);
        right.add(western);

        add(left);
        add(right);

        setVisible(true);
    }

    class RadioListener implements ActionListener
    {
        private JRadioButton focus;

        public RadioListener(JRadioButton b)
        {
            focus = b;
        }

        public void actionPerformed(ActionEvent e)
        {
            int offset = 0;
            if (focus.getText().equals(WEST_TEXT))
                offset = -2;

            String time = getCurrentTime(offset);
            timeText.setText(time);
        }
    }

    private String getCurrentTime(int hrOffset)
    {
        GregorianCalendar cal = new GregorianCalendar();
        String hr = " " + (cal.get(GregorianCalendar.HOUR) + hrOffset);
        String min = "" + cal.get(GregorianCalendar.MINUTE);
        return hr + ":" + min;
    }
}