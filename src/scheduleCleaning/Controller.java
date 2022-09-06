package scheduleCleaning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Model;
import model.ScheduledJob;
import robot.RobotScheduler;
import view.AddScheduleView;
import view.ScheduleView;
import view.ScheduledBox;
import view.TopNav;
import view.View;

/**
 * Control View and update Data
 * @author Soonyoung Park
 *
 */
public class Controller implements ActionListener{
	private static final int frameWidth = 1125/3;  //= 375
	private static final int frameHeight = 2436/3; //= 812
	private ArrayList<ScheduledBox> boxList;
	private View view;
	private Schedule schedule;
	private AddSchedule addSchedule;
	private Label label;
	private Time time;
	private TimeRepeat timeRepeat;
	private Date date;
	private Area area;
	private static Model model;

	private TopNav addScheduleTopNav;
	private TopNav scheduleTopNav;
	private AddScheduleView addScheduleView;
	private ScheduleView scheduleView;
	private ScheduledBox box;
	private ScheduledJob scheduledJob;
	private RobotScheduler myRobot;

	public Controller(){
		myRobot = RobotScheduler.getInstance();
		model = Model.getInstance();
		//after save the cleaning job, reset each view and controller
		newSchedule(model);
	}

	/**
	 * initial instantiation
	 * @param model keeping data
	 */
	public void newSchedule(Model model){
		view = new View();
		schedule = new Schedule(view, model);
		addSchedule = new AddSchedule(view, model);
		label = new Label(view, model);
		time = new Time(view, model);
		timeRepeat = new TimeRepeat(view, model);
		date = new Date(view, model);
		area = new Area(view, model);

		addScheduleTopNav = view.addSchedule().topNav();
		scheduleTopNav = view.schedule().topNav();
		scheduleView = view.schedule();
		addScheduleView = view.addSchedule();
		addScheduleView.addActionListener(this);
		scheduleView.addActionListener(this);
		scheduledJob = ScheduledJob.getInstance();
	}

	/**
	 * instantiation after initial one
	 * After 'save' pressed, 
	 * display data on 'ScheduleView' and
	 * send data to model
	 */
	public void newSchedule() {
		view = new View();
		schedule = new Schedule(view, model);
		addSchedule = new AddSchedule(view, model);
		label = new Label(view, model);
		time = new Time(view, model);
		timeRepeat = new TimeRepeat(view, model);
		date = new Date(view, model);
		area = new Area(view, model);

		addScheduleTopNav = view.addSchedule().topNav();
		scheduleTopNav = view.schedule().topNav();
		scheduleView = view.schedule();
		addScheduleView = view.addSchedule();
		scheduleView.addActionListener(this);
		addScheduleView.addActionListener(this);
	}
	
	/**
	 * send the cleaning job plan to Robot
	 */
	public void signalDataToRobot(){
		System.out.println("MyApp	: ready to send data");
		myRobot.receiveData(scheduledJob.saved().job());
		myRobot.savedJob();
	}
	
	/**
	 * delete i-th job
	 * @param i
	 */
	public void signalDeleteToRobot(int i){
		myRobot.removeData(i);
		myRobot.currentJob();		
	}
	
	/**
	 * reset all the data after save the plan
	 */
	public void reset() {
		model.jobLabel().updateString("Label");
		model.jobDate().updateDate(null);
		model.jobDay().updateString(null);
		model.jobArea().updateString(null);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// when AddScheduleView 'save' button pressed	
		if(e.getSource() == addScheduleTopNav.add()) { 		
			scheduledJob.insert(); // save data into model
			addScheduleView.setVisible(false);
			scheduleView.setVisible(true);
			//instantiation
			newSchedule();
			signalDataToRobot();
			reset();
		}
		
		// 'delete' button pressed	
		for(int i = 0; i< scheduleView.scheduleList().size(); i++) {
			if (e.getSource() == scheduleView.scheduleList().get(i).delete()) {
				scheduledJob.remove(i);
				//instantiation
				newSchedule();
				System.out.println("MyApp	: A schedule deleted");
				signalDeleteToRobot(i);
			}
		}	
	}
}