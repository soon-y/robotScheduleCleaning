package scheduleCleaning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.JobArea;
import model.JobDate;
import model.JobDay;
import model.JobTime;
import model.Model;
import view.AddScheduleView;
import view.AreaView;
import view.DateView;
import view.LabelView;
import view.ScheduleView;
import view.TimeRepeatView;
import view.TimeView;
import view.TopNav;
import view.View;

/**
 * AddScheduleView Controller
 * @author Soonyoung Park
 *
 */
public class AddSchedule implements ActionListener{
	private View view;
	private TopNav topNav;
	private ScheduleView scheduleView;
	private AddScheduleView addScheduleView;
	private LabelView setLabel;
	private TimeView setTime;
	private DateView selectDate;
	private TimeRepeatView selectDay;
	private AreaView selectArea;
	private Boolean validTime = false;
	private Boolean validArea = false;	
	private JobDay jobDay;
	private JobDate jobDate;
	private JobTime jobTime;
	private JobArea jobArea;
	private LocalDateTime now;
	
	public AddSchedule(View view, Model model) {
		this.view = view;
		topNav = view.addSchedule().topNav();
		scheduleView = view.schedule();
		addScheduleView = view.addSchedule();
		setLabel = view.setLabel();
		setTime = view.setTime();
		selectDay = view.selectDay();
		selectDate = view.selectDate();
		selectArea = view.selectArea();
		
		jobTime = model.jobTime();
		jobDate = model.jobDate();
		jobDay = model.jobDay();
		jobArea = model.jobArea();
		
		addScheduleView.setVisible(false);
		addScheduleView.addActionListener(this);
		topNav.add().setVisible(false);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * check if Date/Time & Area are set when 'add' button pressed.
		 */
		if(e.getSource() == addScheduleView.update()) {
			// if time/area is not null, return true
			if ((jobDate.getDate() != null) || (jobDay.getString() != null)) {
				validTime = true;
			}else { 
				validTime = false;
			}	
			// if Area is not null, return true
			if (jobArea.getString() != null) {
				validArea = true;
			}else {
				validArea = false;
			}
			
			/**
			 * Display alert message. 
			 * If it is valid, display 'save' button.
			 */
			if(validTime && validArea) {
				topNav.add().setVisible(true);
				addScheduleView.msg().setText("The schedule is valid.");
			}else if(!validTime && validArea) {
				topNav.add().setVisible(false);
				addScheduleView.msg().setText("Please set Time");
			}else if(!validArea && validTime) {
				topNav.add().setVisible(false);
				addScheduleView.msg().setText("Please set Area");
			}else{
				topNav.add().setVisible(false);
				addScheduleView.msg().setText("The schedule is not valid.");
			}
			
		}
		
		if(e.getSource() == topNav.back()) { 
			addScheduleView.setVisible(false);
			scheduleView.setVisible(true);
		}
		
		if(e.getSource() == addScheduleView.labelEdit()) { 
			addScheduleView.setVisible(false);
			setLabel.setVisible(true);
		}
		
		if(e.getSource() == addScheduleView.timeEdit()) { 
			addScheduleView.setVisible(false);
			setTime.setVisible(true);
			// display current time
			now = LocalDateTime.now();
			setTime.hour().setModel(new SpinnerNumberModel(now.getHour(), 0, 24, 1));
			setTime.minute().setModel(new SpinnerNumberModel(now.getMinute(), 0, 59, 1));
		}
		
		if(e.getSource() == addScheduleView.areaEdit()) { 
			addScheduleView.setVisible(false);
			selectArea.setVisible(true);
		}		
		
	}
}