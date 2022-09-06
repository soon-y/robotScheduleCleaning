package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Display the time setting and toggle for repeat on/off
 * @author Soonyoung Park
 *
 */
public class TimeView extends JPanel implements ViewInterface{
	private SpinnerNumberModel spinner = new SpinnerNumberModel();
	private JSpinner hour = new JSpinner();
	private JSpinner minute = new JSpinner(spinner);
	private JLabel repeat = new JLabel("Repeat");
	private JLabel date = new JLabel("Repeat on");
	private JButton dateEdit = new JButton("select");
	private JToggleButton repeatOn = new JToggleButton("OFF");
	private TopNav topNav;

	public TimeView(int width, int height) {
		topNav = new TopNav(width, height);
		setBackground(Color.white);
		setSize(width, height);
		setLayout(null);
		fontSetting();
		setBounds(width, height);
		addComp();
		setVisible(false);
	}
	
	public TopNav topNav() { return topNav;}
	public JSpinner hour() { return hour;}
	public JSpinner minute() { return minute;}
	public JButton dateEdit() { return dateEdit;}
	public JToggleButton repeatOn() { return repeatOn;}
	public JLabel date() { return date;}
	
	public void addComp() {
		add(topNav);
		add(hour);
		add(minute);
		add(repeat);
		add(date);
		add(dateEdit);
		add(repeatOn);
	}
	
	public void fontSetting() {
		hour.setFont(new Font("Helvetica",  Font.PLAIN, 40));
		minute.setFont(new Font("Helvetica",  Font.PLAIN, 40));
		repeat.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		date.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		dateEdit.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		repeatOn.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		
		dateEdit.setHorizontalAlignment(JLabel.RIGHT);
		
		topNav.add().setText("save");
		topNav.nav().setText("Time");
	}
	
	public void setBounds(int width, int height) {
		int vWidth = width/4;
		int vHeight = height/5/4;
		int y = height/10;
		topNav.setBounds(0, 0, width, height/10);
		hour.setBounds(vWidth, y, vWidth, vHeight*2);
		minute.setBounds(vWidth*2, y, vWidth, vHeight*2);
		repeat.setBounds(10, y+vHeight*2, vHeight*2, vHeight);
		date.setBounds(10, y+vHeight*3, vWidth, vHeight);
		repeatOn.setBounds(vWidth*3, y+vHeight*2, vWidth, vHeight);
		dateEdit.setBounds(vWidth, y+vHeight*3, vWidth*3, vHeight);
		
		colorSetting(dateEdit);
	}
	
	public void colorSetting(JButton button) {
		button.setOpaque(true);
		button.setBackground(Color.white);
		button.setBorderPainted(false);
	}
	
	public void addActionListener(ActionListener listener) {
		dateEdit.addActionListener(listener);
		repeatOn.addActionListener(listener);
		topNav.addActionListener(listener);
	}

}
