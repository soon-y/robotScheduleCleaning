package scheduleCleaning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddScheduleView;
import view.LabelView;
import view.TopNav;
import view.View;
import model.JobLabel;
import model.Model;

/**
 * LabelView controller
 * setting a job label
 * @author Soonyoung Park
 *
 */
public class Label implements ActionListener{
	private View view;
	private TopNav topNav;
	private AddScheduleView addScheduleView;
	private LabelView setLabel;
	private JobLabel jobLabel;
	
	
	public Label(View view, Model model) {
		this.view = view;
		topNav = view.setLabel().topNav();
		addScheduleView = view.addSchedule();
		setLabel = view.setLabel();
		setLabel.setVisible(false);
		setLabel.addActionListener(this);		
		jobLabel = model.jobLabel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// when add button is clicked, save label
		if(e.getSource() == topNav.add()) {
			addScheduleView.setVisible(true);
			setLabel.setVisible(false);
			jobLabel.updateString(setLabel.label().getText());
			addScheduleView.labelEdit().setText(jobLabel.getString());
		}
		
		if(e.getSource() == topNav.back()) { 
			addScheduleView.setVisible(true);
			setLabel.setVisible(false);
		}
	}
}
