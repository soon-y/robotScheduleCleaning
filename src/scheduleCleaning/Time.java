package scheduleCleaning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import model.JobTime;
import model.Model;
import view.AddScheduleView;
import view.DateView;
import view.TimeRepeatView;
import view.TimeView;
import view.TopNav;
import view.View;

/**
 * TimeView controller
 * setting for Time for schedule
 * @author Soonyoung Park
 *
 */
public class Time implements ActionListener{
	private View view;
	private TopNav topNav;
	private AddScheduleView addScheduleView;
	private TimeView setTime;
	private TimeRepeatView selectDay;
	private DateView selectDate;

	public Time(View view, Model model) {
		this.view = view;		
		topNav = view.setTime().topNav();
		addScheduleView = view.addSchedule();
		selectDay = view.selectDay();
		selectDate = view.selectDate();	
		setTime = view.setTime();
		setTime.setVisible(false);
		setTime.addActionListener(this);
		topNav.add().setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == topNav.back()) { 
			addScheduleView.setVisible(true);
			setTime.setVisible(false);
		}

		/**
		 * If repeat on, go to TimeReapeatView
		 * else go to DateView
		 */
		if (setTime.repeatOn().isSelected() == true) {
			setTime.date().setText("Date");
			setTime.repeatOn().setText("OFF");
			if(e.getSource() == setTime.dateEdit()) { 
				setTime.setVisible(false);
				selectDate.setVisible(true);
			}
		}else {	
			setTime.date().setText("Repeat on");
			setTime.repeatOn().setText("ON");
			if(e.getSource() == setTime.dateEdit()) { 
				setTime.setVisible(false);
				selectDay.setVisible(true);

			}				
		}		
	}
}
