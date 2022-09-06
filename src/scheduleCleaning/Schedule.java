package scheduleCleaning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.ScheduledJob;
import view.AddScheduleView;
import view.ScheduledBox;
import view.ScheduleView;
import view.TopNav;
import view.View;

/**
 * Schedule Controller
 * manages planned job on the main schedule page
 * @author Soonyoung Park 
 */

public class Schedule implements ActionListener{
	private View view;
	private TopNav topNav;
	private ScheduleView scheduleView;
	private AddScheduleView addScheduleView;
	private ScheduledJob scheduledJob;
	private Model model;

	public Schedule(View view, Model model) {
		this.view = view;
		topNav = view.schedule().topNav();
		scheduleView = view.schedule();
		addScheduleView = view.addSchedule();
		this.model = model;
		
		scheduleView.setVisible(true);
		scheduleView.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//when save data is clicked
		if(e.getSource() == topNav.add()) {
			scheduleView.setVisible(false);
			addScheduleView.setVisible(true);			
		}
		
		for(int i = 0; i< scheduleView.scheduleList().size(); i++) {
			if (scheduleView.scheduleList().get(i).onOff().isSelected() == true) {
				scheduleView.scheduleList().get(i).ColorSetting(new Color(212, 212, 212));
				scheduleView.scheduleList().get(i).onOff().setText("OFF");
			}else {
				scheduleView.scheduleList().get(i).ColorSetting(Color.black);	
				scheduleView.scheduleList().get(i).onOff().setText("ON");
			}
		}	
	}


}
