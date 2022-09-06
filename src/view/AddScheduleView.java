package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Display menus to set planning; Label, Time, Area
 * @author Soonyoung Park
 *
 */
public class AddScheduleView extends JPanel implements ViewInterface{
	private TopNav topNav;
	private JLabel label = new JLabel("Label");
	private JLabel time = new JLabel("Time");
	private JLabel area = new JLabel("Area");
	private JButton labelEdit = new JButton("edit >");
	private JButton timeEdit = new JButton("edit >");
	private JButton areaEdit = new JButton("edit >");
	private JLabel msg = new JLabel("Please add this schedule.");
	private JButton update = new JButton("add");
	
	public AddScheduleView(int width, int height) {
		topNav = new TopNav(width, height);		
		setBackground(Color.white);
		setLayout(null);
		setSize(width, height);
		fontSetting();
		setBounds(width, height);
		addComp();		
		setVisible(false);
	}
	
	public TopNav topNav() { return topNav;}
	public JButton labelEdit() {return labelEdit;}
	public JButton timeEdit() {return timeEdit;}
	public JButton areaEdit() {return areaEdit;}
	public JLabel msg() {return msg;}
	public JButton update() {return update;}
	
	public void addComp() {
		add(topNav);
		add(label);
		add(time);
		add(area);
		add(labelEdit);
		add(timeEdit);
		add(areaEdit);
		add(msg);
		add(update);
	}
	
	public void setBounds(int width, int height) {
		int vWidth = width/5;
		int vHeight = height/3/6;
		int y = height/10;
		int margin = 10;
		
		topNav.setBounds(0, 0, width, height/10);
		label.setBounds(margin, y, vWidth, vHeight);
		time.setBounds(margin, y+vHeight, vWidth, vHeight);
		area.setBounds(margin, y+vHeight*2, vWidth, vHeight);
		labelEdit.setBounds(vWidth, y, vWidth*4, vHeight);
		timeEdit.setBounds(vWidth, y+vHeight, vWidth*4, vHeight);
		areaEdit.setBounds(vWidth, y+vHeight*2, vWidth*4, vHeight);
		msg.setBounds(margin, y+vHeight*3, width, vHeight);
		update.setBounds(margin, y+vHeight*4, width-margin*2, vHeight);
		
		label.setHorizontalAlignment(JLabel.LEFT);
		time.setHorizontalAlignment(JLabel.LEFT);
		area.setHorizontalAlignment(JLabel.LEFT);
		labelEdit.setHorizontalAlignment(JLabel.RIGHT);
		timeEdit.setHorizontalAlignment(JLabel.RIGHT);
		areaEdit.setHorizontalAlignment(JLabel.RIGHT);
		msg.setHorizontalAlignment(JLabel.LEFT);
		
		label.setVerticalAlignment(JLabel.BOTTOM);
		area.setVerticalAlignment(JLabel.TOP);
		labelEdit.setVerticalAlignment(JLabel.BOTTOM);
		areaEdit.setVerticalAlignment(JLabel.TOP);
		
		colorSetting(labelEdit);
		colorSetting(timeEdit);
		colorSetting(areaEdit);
	}
	
	public void colorSetting(JButton button) {
		button.setOpaque(true);
		button.setBackground(Color.white);
		button.setBorderPainted(false);
	}
	
	public void fontSetting() {
		
		label.setFont(new Font("Helvetica", Font.PLAIN, 16));
		time.setFont(new Font("Helvetica", Font.PLAIN, 16));
		area.setFont(new Font("Helvetica", Font.PLAIN, 16));
		labelEdit.setFont(new Font("Helvetica", Font.BOLD, 16));
		timeEdit.setFont(new Font("Helvetica", Font.BOLD, 16));
		areaEdit.setFont(new Font("Helvetica", Font.BOLD, 16));
		msg.setFont(new Font("Helvetica", Font.PLAIN, 16));
		update.setFont(new Font("Helvetica", Font.PLAIN, 16));
		
		topNav.add().setText("save");
		topNav.nav().setText("Add Schedule");
	}
	
	public void addActionListener(ActionListener listener) {
		labelEdit.addActionListener(listener);
		timeEdit.addActionListener(listener);
		areaEdit.addActionListener(listener);
		topNav.addActionListener(listener);
		update.addActionListener(listener);
	}
		
}
