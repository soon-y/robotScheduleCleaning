/*
 * Displays generated maps and areas
 */
package view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.Font;
import java.awt.Color;

/**
 * Display floor plan to select Room/Region to clean in Room/Region mode 
 * @author Soonyoung Park
 *
 */
public class AreaView extends JPanel implements ViewInterface{
	private JToggleButton mode = new JToggleButton("ROOM Mode");
	private JToggleButton roomA = new JToggleButton("A");
	private JToggleButton roomB = new JToggleButton("B");
	private JToggleButton roomC = new JToggleButton("C");
	private TopNav topNav;

	public AreaView(int width, int height) {
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
	public JToggleButton mode() { return mode;}
	public JToggleButton roomA() { return roomA;}
	public JToggleButton roomB() { return roomB;}
	public JToggleButton roomC() { return roomC;}
	
	public void addComp() {
		add(mode);
		add(roomA);
		add(roomB);
		add(roomC);
		add(topNav);
	}
	
	public void fontSetting() {
		mode.setFont(new Font("Helvetica",  Font.PLAIN, 20));
		roomA.setFont(new Font("Helvetica",  Font.PLAIN, 40));
		roomB.setFont(new Font("Helvetica",  Font.PLAIN, 40));
		roomC.setFont(new Font("Helvetica",  Font.PLAIN, 40));
		
		topNav.add().setText("save");
		topNav.nav().setText("Area");
	}
	
	public void setBounds(int width, int height) {
		int vWidth = width/8;
		int vHeight = height/20;
		int y = height/10;
		
		topNav.setBounds(0, 0, width, height/10);
		mode.setBounds(10, y+10, vWidth*8-20, vHeight);
		roomA.setBounds(vWidth*2, y+vHeight*3, vWidth*4, vHeight*4);
		roomB.setBounds(vWidth*1, y+vHeight*7, vWidth*3, vHeight*9);
		roomC.setBounds(vWidth*4, y+vHeight*7, vWidth*3, vHeight*4);
		
		setColor(roomA, new Color(233, 233, 233));
		setColor(roomB, new Color(233, 233, 233));
		setColor(roomC, new Color(233, 233, 233));
	}
	
	public void setColor(JToggleButton button, Color color) {
		button.setOpaque(true);
		button.setBackground(color);
		button.setBorderPainted(false);
	}
	
	public void addActionListener(ActionListener listener) {
		topNav.addActionListener(listener);
		roomA.addActionListener(listener);
		roomB.addActionListener(listener);
		roomC.addActionListener(listener);
		mode.addActionListener(listener);
	}
}
