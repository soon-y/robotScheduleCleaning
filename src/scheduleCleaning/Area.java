package scheduleCleaning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.JobArea;
import model.Model;
import view.AddScheduleView;
import view.AreaView;
import view.TopNav;
import view.View;

/**
 * Area Controller
 * setting area to clean in room mode
 * @author Soonyoung Park
 *
 */
public class Area implements ActionListener{
	private View view;
	private TopNav topNav;
	private AddScheduleView addSchedule;
	private AreaView selectArea;
	private JobArea jobArea;

	public Area(View view, Model model) {
		this.view = view;
		topNav = view.selectArea().topNav();
		addSchedule = view.addSchedule();
		selectArea = view.selectArea();
		selectArea.setVisible(false);
		selectArea.addActionListener(this);

		jobArea = model.jobArea();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// when 'save' button is clicked 
		if(e.getSource() == topNav.add()) {
			addSchedule.setVisible(true);
			selectArea.setVisible(false);
			addSchedule.areaEdit().setText(jobArea.getString());
		}		
		if(e.getSource() == topNav.back()) { 
			addSchedule.setVisible(true);
			selectArea.setVisible(false);
		}

		// switch mode: Room mode / Region mode
		if (selectArea.mode().isSelected()) {
			selectArea.mode().setBackground(Color.white);
			selectArea.mode().setText("REIGION Mode");
			selectArea.roomA().setText(null);
			selectArea.roomB().setText(null);
			selectArea.roomC().setText(null);
		}else {
			selectArea.mode().setText("ROOM Mode");
			selectArea.roomA().setText("A");
			selectArea.roomB().setText("B");
			selectArea.roomC().setText("C");

			if(e.getSource() == selectArea.roomA()) { 
				jobArea.updateString("room A");		
			}else if(e.getSource() == selectArea.roomB()) {
				jobArea.updateString("room B");
			}else if(e.getSource() == selectArea.roomC()) {
				jobArea.updateString("room C");
			}
		}
	}
}
