package view;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import com.github.lgooddatepicker.components.DatePicker;

/**
 * Display calendar to select date
 * @author Soonyoung Park
 *
 */
public class DateView extends JPanel implements ViewInterface{
    LocalDate date = LocalDate.now();
    private DatePicker datePicker = new DatePicker();
    private JLabel msg = new JLabel("Please select date.");
    private JButton update = new JButton("Add");
    private TopNav topNav;

    public DateView(int width, int height) {
        topNav = new TopNav(width, height);
        setBackground(Color.white);
        setSize(width, height);
        setLayout(null);
        setVisible(false);
        fontSetting();
        setBounds(width, height);
        addComp();    
    }
    
    public TopNav topNav() { return topNav;}
    public DatePicker datePick() {return datePicker;}
    public JLabel msg() {return msg;}
    public JButton update() {return update;}
    
    public void addComp() {
        add(topNav);
        add(datePicker);
        add(update);
        add(msg);
    }
    
    public void setBounds(int width, int height) {
        int margin = 10;
        int wHeight = height/20;
        int y = height/10;
        topNav.setBounds(0, 0, width, height/10);
        datePicker.setBounds(margin, y+margin, width-margin*2, wHeight);
        msg.setBounds(margin, y+wHeight+margin, width-margin*2, wHeight);
        update.setBounds(margin, y+wHeight*2+margin, width-margin*2, wHeight);

        datePicker.getComponentToggleCalendarButton().setText("edit >");
        datePicker.getComponentToggleCalendarButton().setText("Select");
        datePicker.getComponentToggleCalendarButton().setHorizontalAlignment(SwingConstants.LEFT);
        datePicker.getComponentToggleCalendarButton().setForeground(new Color(255, 165, 0));
        datePick().setDate(LocalDate.now());
    }
    
    public void fontSetting() {
        datePicker.getComponentToggleCalendarButton().setFont(new Font("Roboto",  Font.PLAIN, 14));
        datePicker.getComponentToggleCalendarButton().setForeground(Color.BLACK);
        datePicker.getComponentDateTextField().setFont(new Font("Roboto",  Font.PLAIN, 14));
        update.setFont(new Font("Roboto",  Font.PLAIN, 14));
        topNav.add().setText("save");
        topNav.nav().setText("Time");
    }
    
    public void addActionListener(ActionListener listener) {
        topNav.addActionListener(listener);
        update.addActionListener(listener);

    }

}