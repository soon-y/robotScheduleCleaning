package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Top navigation bar: back button, Navigation, add/save button
 * @author Soonyoung Park
 *
 */
public class TopNav extends JPanel implements ViewInterface{
	private JButton back = new JButton("<");
	private JButton add = new JButton(" ");
	private JLabel nav = new JLabel("Schedule");
	
	public TopNav(int width, int height) {
		Color bg = new Color(189, 226, 255);
		setBackground(bg);
		setLayout(null);
		setSize(width, height/10);
		fontSetting();
		setBounds(width/4, height/10);
		addComp();
		setVisible(true);
	}
	
	public JButton back() {return back;}
	public JButton add() {return add;}
	public JLabel nav() {return nav;}
	
	public void addComp() {
		add(add);
		add(back);
		add(nav);
	}
	
	public void fontSetting() {
		back.setFont(new Font("Roboto", Font.PLAIN, 22));
		add.setFont(new Font("Roboto", Font.PLAIN, 20));
		nav.setFont(new Font("Helvetica", Font.PLAIN, 24));
	}
	
	public void setBounds(int width, int height) {
		back.setBounds(0, 0, width, height);
		nav.setBounds(width, 0, width*2, height);
		add.setBounds(width*3, 0, width, height);	
		nav.setHorizontalAlignment(JLabel.CENTER);
		back.setHorizontalAlignment(JLabel.LEFT);
		add.setHorizontalAlignment(JLabel.RIGHT);
		colorSetting(add);
		colorSetting(back);	
	}
	
	public void colorSetting(JButton button) {
		Color bg = new Color(189, 226, 255);
		button.setOpaque(true);
		button.setBackground(bg);
		button.setBorderPainted(false);
	}
	
	public void addActionListener(ActionListener listener) {
		add.addActionListener(listener);
		back.addActionListener(listener);
	}
	
}
