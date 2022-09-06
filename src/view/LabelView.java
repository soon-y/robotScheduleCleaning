package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Name the schedule job.
 * @author Soonyoung Park
 *
 */
public class LabelView extends JPanel implements ViewInterface {
	private JTextField label = new JTextField("Label");
	private TopNav topNav;
	
	public LabelView(int width, int height){
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
	public JTextField label() {return label;}
	
	public void addComp() {
		add(topNav);
		add(label);
	}
	
	public void fontSetting() {
		label.setFont(new Font("Helvetica", Font.PLAIN, 14));
		topNav.add().setText("save");
		topNav.nav().setText("Label");
	}
	
	public void setBounds(int width, int height) {
		int vHeight = height/10;
		int y = height/10;
		topNav.setBounds(0, 0, width, height/10);
		label.setBounds(10, y+vHeight/3, width-20, vHeight/2);
		colorSetting(label);

	}
	
	public void colorSetting(JTextField text) {
		Color bg = new Color(243,243,243);
		text.setBackground(bg);
	}
	
	public void addActionListener(ActionListener listener) {
		topNav.addActionListener(listener);
	}
}
