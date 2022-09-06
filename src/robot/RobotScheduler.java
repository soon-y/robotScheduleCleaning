package robot;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Boundary of robot
 * Precondition: 
 * User must be logged into app and has done the initial pairing with the Robot.
 * Robot is turned on and on standby.
 * @author Soonyoung Park
 *
 */

public class RobotScheduler {
	private static RobotScheduler Instance = null;
	private LinkedList<String> job;	
	private ArrayList<LinkedList> jobList;
	public LinkedList<String> job() {return job;}
	public ArrayList<LinkedList> jobList() {return jobList;}

	public RobotScheduler(){
		System.out.println("+--------------------------------+");
		System.out.println("|  User account: HAW-SEL5        |");	
		System.out.println("|  Successfully paired my Robot  |");
		System.out.println("+--------------------------------+");
		job = new LinkedList<>();
		jobList = new ArrayList<>();
	}

	/**
	 * when new job plan is saved
	 * @param data
	 */
	public void receiveData(LinkedList data) {
		System.out.println("MyRobot	: ready to receive Data");
		job = data;
		jobList.add(job);
	}

	/**
	 * when i-th job is deleted
	 * @param i
	 */
	public void removeData(int i) {
		System.out.println("MyRobot	: remove the schedule");
		jobList.remove(i);
	}

	public void currentJob() {
		System.out.println("MyRobot.currentJobs() : " + jobList.size());
		for(int i = 0; i<jobList.size(); i++) {
			savedJob(i);
		}
	}
	
	/**
	 * show all the jobs planned
	 * @param i
	 */
	public void savedJob(int i){
		int hour = Integer. parseInt((String)jobList.get(i).get(1));
		int min = Integer. parseInt((String)jobList.get(i).get(2));
		LocalTime time = getTime(hour, min);

		String dd = (String)jobList.get(i).get(5);
		String mm = (String)jobList.get(i).get(6);
		String yyyy = (String)jobList.get(i).get(7);
		
		System.out.println("+---------------+--------------------------------" );
		System.out.println("| ScheduledJob  | " + i+1 );
		System.out.println("+---------------+--------------------------------" );
		System.out.println("| Label		| " + jobList.get(i).get(0));
		System.out.println("+---------------+--------------------------------" );
		System.out.println("| Time		| " + time);
		System.out.println("+---------------+--------------------------------" );
		if(jobList.get(i).get(3) == " ") {
			System.out.println("| Date		| " + dd+"/"+mm+"/"+yyyy);
			System.out.println("+---------------+--------------------------------" );
		}else {
			System.out.println("| Repeat on	| " + jobList.get(i).get(3));
			System.out.println("+---------------+--------------------------------" );
		}
		System.out.println("| Area		| " + jobList.get(i).get(8));
		System.out.println("+---------------+--------------------------------" );
		System.out.println();
	}
	
	/**
	 * show the saved job
	 */
	public void savedJob(){
		int hour = Integer. parseInt((String)job().get(1));
		int min = Integer. parseInt((String)job().get(2));
		LocalTime time = getTime(hour, min);

		String dd = (String)job().get(5);
		String mm = (String)job().get(6);
		String yyyy = (String)job().get(7);

		System.out.println("+---------------+--------------------------------" );
		System.out.println("| Label		| " + job().get(0));
		System.out.println("+---------------+--------------------------------" );
		System.out.println("| Time		| " + time);
		System.out.println("+---------------+--------------------------------" );
		if(job().get(3) == " ") {
			System.out.println("| Date		| " + dd+"/"+mm+"/"+yyyy);
			System.out.println("+---------------+--------------------------------" );
		}else {
			System.out.println("| Repeat on	| " + job().get(3));
			System.out.println("+---------------+--------------------------------" );
		}
		System.out.println("| Area		| " + job().get(8));
		System.out.println("+---------------+--------------------------------" );
		System.out.println();
	}

	public LocalTime getTime(int hour, int minute) {
		LocalTime time;
		time = LocalTime.of(hour, minute);
		return time.truncatedTo(ChronoUnit.MINUTES);
	}

	public static RobotScheduler getInstance(){
		if (Instance == null) {
			Instance = new RobotScheduler();
		}
		return Instance;
	}

}
