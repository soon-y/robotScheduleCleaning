package scheduleCleaning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import model.JobDate;
import model.JobDay;
import model.JobTime;
import model.Model;
import view.AddScheduleView;
import view.DateView;
import view.TimeView;
import view.TopNav;
import view.View;

/**
 * Date Controller
 * setting date for cleaning job if not repeated
 * @author Soonyoung Park
 *
 */
public class Date implements ActionListener{
	private View view;
	private TopNav topNav;
	private TimeView setTime;
	private DateView selectDate;
	private AddScheduleView addScheduleView;
	private JobDate jobDate;
	private JobTime jobTime;
	private JobDay jobDay;

	public Date(View view, Model model) {
		this.view = view;
		topNav = view.selectDate().topNav();
		setTime = view.setTime();
		addScheduleView = view.addSchedule();
		selectDate = view.selectDate();
		selectDate.setVisible(false);
		selectDate.addActionListener(this);

		jobTime = model.jobTime();
		jobDate = model.jobDate();
		jobDay = model.jobDay();
		
		topNav.add().setVisible(false);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// 'add' button pressed, save Time and Date
		if(e.getSource() == selectDate.update()) {
			int hour = (Integer)setTime.hour().getValue();
			int min = (Integer)setTime.minute().getValue();
			jobTime.updateTime(hour, min);		
			
			/**
			 * Check if the date/time is valid, if so, display and update it;
			 * Date is later than today: valid
			 * Date is Today, Time is later than current time: valid
			 */
			LocalDate date = selectDate.datePick().getDate();
			LocalDate today = LocalDate.now();
			if(date.compareTo(today) > 0) {
				jobDate.updateDate(date);
				topNav.add().setVisible(true);
				selectDate.msg().setText("Time is valid.");
				addScheduleView.timeEdit().setText(jobDate.getString()+" "+jobTime.getString());
			}else if (date.equals(today)) {
				LocalTime now = LocalTime.now();
				LocalTime scheduled = jobTime.getTime();
				if(scheduled.isAfter(now)) {
					jobDate.updateDate(date);
					topNav.add().setVisible(true);
					selectDate.msg().setText("Time is valid.");
					addScheduleView.timeEdit().setText(jobDate.getString()+" "+jobTime.getString());
				}else {
					selectDate.msg().setText("Please set Time again.");
					topNav.add().setVisible(false);
				}				
			}else {
				selectDate.msg().setText("Date is not valid.");
				topNav.add().setVisible(false);
			}
		}
		// when 'save' button is clicked 
		if(e.getSource() == topNav.add()) {
			addScheduleView.setVisible(true);
			selectDate.setVisible(false);
			jobDay.updateString(null); // reset TimeRepeat
		}		
		if(e.getSource() == topNav.back()) { 
			setTime.setVisible(true);
			selectDate.setVisible(false);
		}

	}
}
