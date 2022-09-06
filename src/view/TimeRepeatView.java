package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Display options to select which day to repeat the cleaning job
 * @author Soonyoung Park
 *
 */
public class TimeRepeatView extends JPanel implements ViewInterface{
	private Boolean bool = false;
	private JToggleButton mon = new JToggleButton("Every Monday",bool());
	private JToggleButton tue = new JToggleButton("Every Tuesday",bool());
	private JToggleButton wed = new JToggleButton("Every Wednesday",bool());
	private JToggleButton thu = new JToggleButton("Every Thursday",bool());
	private JToggleButton fri = new JToggleButton("Every Friday",bool());
	private JToggleButton sat = new JToggleButton("Every Saturday",bool());
	private JToggleButton sun = new JToggleButton("Every Sunday",bool());
	private JButton update = new JButton("Add");
	private TopNav topNav;
	
	public TimeRepeatView(int width, int height) {	
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
	public JToggleButton mon() {return mon;}
	public JToggleButton tue() {return tue;}
	public JToggleButton wed() {return wed;}
	public JToggleButton thu() {return thu;}
	public JToggleButton fri() {return fri;}
	public JToggleButton sat() {return sat;}
	public JToggleButton sun() {return sun;}
	public JButton update() {return update;}
	public Boolean bool() {return bool;}
	public void setBool(Boolean bool) {this.bool = bool;}
	
	
	public void setBounds(int width, int height) {
		int vWidth = width/4;
		int vHeight = height/15;
		int y = height/10+10;
		
		topNav.setBounds(0, 0, width, height/10);
		mon.setBounds(10, y, vWidth*3-20, vHeight);
		tue.setBounds(10, y+vHeight, vWidth*3-20, vHeight);
		wed.setBounds(10, y+vHeight*2, vWidth*3-20, vHeight);
		thu.setBounds(10, y+vHeight*3, vWidth*3-20, vHeight);
		fri.setBounds(10, y+vHeight*4, vWidth*3-20, vHeight);
		sat.setBounds(10, y+vHeight*5, vWidth*3-20, vHeight);
		sun.setBounds(10, y+vHeight*6, vWidth*3-20, vHeight);
		update.setBounds(10+vWidth*3, y, vWidth-20, vHeight*7);
		
		mon.setHorizontalAlignment(JLabel.LEFT);
		tue.setHorizontalAlignment(JLabel.LEFT);
		wed.setHorizontalAlignment(JLabel.LEFT);
		thu.setHorizontalAlignment(JLabel.LEFT);
		fri.setHorizontalAlignment(JLabel.LEFT);
		sat.setHorizontalAlignment(JLabel.LEFT);
		sun.setHorizontalAlignment(JLabel.LEFT);
		
		colorSetting(mon);
		colorSetting(tue);
		colorSetting(wed);
		colorSetting(thu);
		colorSetting(fri);
		colorSetting(sat);
		colorSetting(sun);
		colorSetting(update);	
	}
	
	public void addComp() {
		add(mon); add(tue);	add(wed); add(thu); add(update);
		add(fri); add(sat);	add(sun); add(topNav);
	}
	
	public void colorSetting(JToggleButton button) {		
		button.setOpaque(true);
		button.setBackground(Color.white);
		button.setBorderPainted(false);
	}
	
	public void colorSetting(JButton button) {		
		button.setOpaque(true);
		button.setBackground(Color.white);
		button.setBorderPainted(false);
	}
	
	public void fontSetting() {		
		mon.setFont(new Font("Helvetica", Font.PLAIN, 16));
		tue.setFont(new Font("Helvetica", Font.PLAIN, 16));
		wed.setFont(new Font("Helvetica", Font.PLAIN, 16));
		thu.setFont(new Font("Helvetica", Font.PLAIN, 16));
		fri.setFont(new Font("Helvetica", Font.PLAIN, 16));
		sat.setFont(new Font("Helvetica", Font.PLAIN, 16));
		sun.setFont(new Font("Helvetica", Font.PLAIN, 16));
		update.setFont(new Font("Helvetica", Font.PLAIN, 16));
		
		topNav.add().setText("save");
		topNav.nav().setText("Time");
	}
	
	public void addActionListener(ActionListener listener) {
		topNav.addActionListener(listener);
		update.addActionListener(listener);
	}
	
}
