package view;

import javax.swing.JFrame;

/**
 * Display all the JPanels
 * @author Soonyoung Park
 *
 */
public class View extends JFrame{
	//iphone 11 pro: 1125 * 2436
	private static final int frameWidth = 1125/3;  //= 375
	private static final int frameHeight = 2436/3; //= 812
		
	private ScheduleView schedule;
	private ScheduledBox box;
	private AddScheduleView addSchedule;
	private LabelView setLabel;
	private TimeView setTime;
	private TimeRepeatView selectDay;
	private DateView selectDate;
	private AreaView selectArea;
		
	public ScheduleView schedule() { return schedule;}	
	public AddScheduleView addSchedule() {return addSchedule;}
	public LabelView setLabel() {return setLabel;}
	public TimeView setTime() {return setTime;}
	public TimeRepeatView selectDay() {return selectDay;}
	public DateView selectDate() {return selectDate;}
	public AreaView selectArea() {return selectArea;}
	public ScheduledBox box() {return box;}
	
	
	public View(){
		schedule= new ScheduleView(frameWidth, frameHeight);
		box = new ScheduledBox(frameWidth, frameHeight/5);
		addSchedule = new AddScheduleView(frameWidth, frameHeight);
		setLabel = new LabelView(frameWidth, frameHeight);
		setTime = new TimeView(frameWidth, frameHeight);
		selectDay = new TimeRepeatView(frameWidth, frameHeight);
		selectDate = new DateView(frameWidth, frameHeight);
		selectArea = new AreaView(frameWidth, frameHeight);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(frameWidth, frameHeight);
		setLayout(null);
		setPosition();
		addComp();	
		setVisible(true);
	}
	
	public void setPosition() {
		schedule.setLocation(0,0);
		addSchedule.setLocation(0, 0);
		setLabel.setLocation(0, 0);
		setTime.setLocation(0, 0);
		selectDay.setLocation(0,0);
		selectDate.setLocation(0,0);
		selectArea.setLocation(0,0);
	}
	
	public void addComp() {
		add(selectArea);
		add(selectDate);
		add(selectDay);
		add(setTime);
		add(setLabel);
		add(addSchedule);
		add(schedule);
	}

}
