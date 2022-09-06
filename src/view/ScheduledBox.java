package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Each scheduled job; is displayed on ScheduledView.
 * @author Soonyoung Park
 *
 */
public class ScheduledBox extends JPanel implements ViewInterface{
	private JLabel label = new JLabel(" ");
	private JLabel time = new JLabel(" ");
	private JLabel date = new JLabel(" ");
	private JButton delete = new JButton("delete");
	private JToggleButton onOff = new JToggleButton("ON");
	
	public ScheduledBox(int width, int height){
		setBackground(Color.white);
		setLayout(null);
		setSize(width, height);
		fontSetting();
		setBounds(width/4, height/4);
		addComp();		
		setVisible(false);
	}
	
	public JLabel label() {return label;}
	public JLabel time() {return time;}
	public JLabel date() {return date;}
	public JButton delete() {return delete;}
	public JToggleButton onOff() {return onOff;}


	
	public void addComp() {
		add(label);
		add(time);
		add(date);
		add(delete);
		add(onOff);
	}
	
	public void fontSetting() {
		label.setFont(new Font("Helvetica",  Font.PLAIN, 18));
		time.setFont(new Font("Helvetica",  Font.PLAIN, 50));
		date.setFont(new Font("Helvetica",  Font.PLAIN, 18));
		delete.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		ColorSetting(Color.black);
		}
	
	public void ColorSetting(Color color) {
		label.setForeground(color);
		time.setForeground(color);
		date.setForeground(color);
	}
		
	public void setBounds(int width, int height) {	
		label.setBounds(10, 0, width*2, height);
		time.setBounds(10, height, width*2, height*2);
		date.setBounds(10, height*3, width*2, height);
		onOff.setBounds(width*3, height, width, height*2);
		delete.setBounds(width*3, height*3, width, height);
		label.setVerticalAlignment(JLabel.BOTTOM);
		date.setVerticalAlignment(JLabel.TOP);
		
	}
	
	public void addActionListener(ActionListener listener) {
		onOff.addActionListener(listener);
		delete.addActionListener(listener);
		}	
}
