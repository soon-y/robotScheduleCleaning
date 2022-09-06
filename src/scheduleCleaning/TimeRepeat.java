package scheduleCleaning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.JobDate;
import model.JobDay;
import model.JobTime;
import model.Model;
import view.AddScheduleView;
import view.TimeRepeatView;
import view.TimeView;
import view.TopNav;
import view.View;

/**
 * TimeRepeatView Controller
 * selecting which day to repeat the cleaning job
 * @author Soonyoung Park
 *
 */
public class TimeRepeat implements ActionListener{
	private View view;
	private TopNav topNav;
	private TimeView setTime;
	private TimeRepeatView selectDay;
	private AddScheduleView addScheduleView;
	private JobDay jobDay;
	private JobTime jobTime;
	private JobDate jobDate;


	public TimeRepeat(View view, Model model) {
		this.view = view;
		topNav = view.selectDay().topNav();
		setTime = view.setTime();
		addScheduleView = view.addSchedule();
		selectDay = view.selectDay();
		selectDay.setVisible(false);
		selectDay.addActionListener(this);
		topNav.add().setVisible(false);	

		jobTime = model.jobTime();
		jobDay = model.jobDay();
		jobDate = model.jobDate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String days = " ";

		if(e.getSource() == topNav.back()) { 
			setTime.setVisible(true);
			selectDay.setVisible(false);
		}

		// 'save' button pressed
		if(e.getSource() == topNav.add()) {
			addScheduleView.setVisible(true);
			selectDay.setVisible(false);
			jobDate.updateDate(null); // reset Date
		}	

		//add data into TreeMap(model) and update DataEdit 
		if(e.getSource() == selectDay.update()) { 
			// if all the days are in TreeMap, update String as 'Everyday'.
			if(jobDay.getTreeMap().containsKey(0) && jobDay.getTreeMap().containsKey(1)&&jobDay.getTreeMap().containsKey(2)
					&&jobDay.getTreeMap().containsKey(3)&&jobDay.getTreeMap().containsKey(4)&&
					jobDay.getTreeMap().containsKey(5)&&jobDay.getTreeMap().containsKey(6)) { 
				days = "Everyday"; jobDay.updateString(days);
			// if only weekend are in TreeMap, update String as 'Every weekend'.
			}else if(!jobDay.getTreeMap().containsKey(0) && !jobDay.getTreeMap().containsKey(1)
					&&!jobDay.getTreeMap().containsKey(2)&&!jobDay.getTreeMap().containsKey(3)
					&&!jobDay.getTreeMap().containsKey(4)&&jobDay.getTreeMap().containsKey(5)&&jobDay.getTreeMap().containsKey(6)) {		
				days = "Every weekend"; jobDay.updateString(days);
			// if only weekend is in TreeMap, update String as 'Every weekday'.
			}else if(jobDay.getTreeMap().containsKey(0) && jobDay.getTreeMap().containsKey(1)
					&&jobDay.getTreeMap().containsKey(2)&&jobDay.getTreeMap().containsKey(3)
					&&jobDay.getTreeMap().containsKey(4)&&!jobDay.getTreeMap().containsKey(5)&&!jobDay.getTreeMap().containsKey(6)) {
				days = "Every weekday"; jobDay.updateString(days);
			}else {	
				days = "Every " + jobDay.getTreeMap().values();
				jobDay.updateString(days);
			}
			
			//Save Time, and display Time and repeated Days.
			int hour = (Integer)setTime.hour().getValue();
			int min = (Integer)setTime.minute().getValue();
			jobTime.updateTime(hour, min);
			addScheduleView.timeEdit().setText(days+" "+jobTime.getString());

			//If TreeMap is empty do not display 'save' button.
			if(jobDay.getTreeMap().isEmpty()) {
				topNav.add().setVisible(false);
			}else {
				topNav.add().setVisible(true);
			}
		}

		/**
		 * put String into TreeMap; Key is for the order.
		 */
		if(selectDay.mon().isSelected()) {
			jobDay.getTreeMap().put(0, "Mon");
		}else {
			jobDay.getTreeMap().remove(0);
		}

		if(selectDay.tue().isSelected()) {
			jobDay.getTreeMap().put(1, "Tue ");
		}else {
			jobDay.getTreeMap().remove(1);
		}

		if(selectDay.wed().isSelected()) {
			jobDay.getTreeMap().put(2, "Wed ");
		}else {
			jobDay.getTreeMap().remove(2);
		}

		if(selectDay.thu().isSelected()) {
			jobDay.getTreeMap().put(3, "Thu");
		}else {
			jobDay.getTreeMap().remove(3);
		}

		if(selectDay.fri().isSelected()) {
			jobDay.getTreeMap().put(4, "Fri");
		}else {
			jobDay.getTreeMap().remove(4);
		}

		if(selectDay.sat().isSelected()) {
			jobDay.getTreeMap().put(5, "Sat");
		}else {
			jobDay.getTreeMap().remove(5);
		}

		if(selectDay.sun().isSelected()) {
			jobDay.getTreeMap().put(6, "Sun");
		}else {
			jobDay.getTreeMap().remove(6);
		}

	}
}