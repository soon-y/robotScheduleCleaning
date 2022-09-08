package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.ScheduledJob;

/**
 * Main Schedule page; displays planned jobs
 * @author Soonyoung Park
 *
 */
public class ScheduleView extends JPanel implements ViewInterface{
	private TopNav topNav;
	private ArrayList<ScheduledBox> boxList;
	private ScheduledBox box;
	private ScheduledJob scheduledJob;

	public ScheduleView(int width, int height){
		scheduledJob = ScheduledJob.getInstance();
		topNav = new TopNav(width, height);
		boxList = new ArrayList<>();
		displayBox(width, height/5, scheduledJob);
		setBackground(Color.white);
		setLayout(null);
		setSize(width, height);
		fontSetting();
		setBounds(width, height);
		addComp();		
		setVisible(true);
	}

	public ArrayList<ScheduledBox> scheduleList() { return boxList;}
	public TopNav topNav() { return topNav;}

	public void displayBox(int width, int height, ScheduledJob job) {
		if(!scheduledJob.isEmpty()) {
			for(int i = 0; i<scheduledJob.size(); i++) {
				box = new ScheduledBox(width, height);
				//display data on ScheduleBox
				box.label().setText(scheduledJob.get(i, 0));
				box.time().setText(scheduledJob.get(i, 1) +":"+scheduledJob.get(i, 2));
				box.date().setText(scheduledJob.get(i, 4));							
				boxList.add(box);
			}
		}
	}

	public void addComp() {
		add(topNav);
		for(int i = 0; i<boxList.size(); i++) {
			add(boxList.get(i));
			boxList.get(i).setVisible(true);
		}	
	}	

	public void fontSetting() {		
		topNav.add().setText("+");
		topNav.nav().setText("Schedule");
	}

	public void setBounds(int width, int height) {		
		int boxHeight = height/5;
		int topMargin = height/10;		
		topNav.setBounds(0, 0, width, topMargin);
		for(int i = 0; i<boxList.size(); i++) {
			boxList.get(i).setBounds(0, topMargin + boxHeight * i, width, boxHeight);
		}
	}

	public void addActionListener(ActionListener listener) {
		topNav.addActionListener(listener);
		for(int i = 0; i<boxList.size(); i++) {
			boxList.get(i).addActionListener(listener);
		}
	}	
}
