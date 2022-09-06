package model;

/**
 * Model single instance
 * Keep all the data
 * @author Soonyoung Park
 *
 */
public class Model {
	private static Model Instance = null;
	private JobLabel jobLabel;
	private JobTime jobTime;
	private JobArea jobArea;
	private JobDate jobDate;
	private JobDay jobDay;

	private Model(){
		jobLabel = new JobLabel();
		jobTime = new JobTime();
		jobArea = new JobArea();
		jobDate = new JobDate();
		jobDay = new JobDay();
	}

	public JobLabel jobLabel() {return jobLabel;}
	public JobTime jobTime() {return jobTime;}
	public JobArea jobArea() {return jobArea;}
	public JobDate jobDate() {return jobDate;}
	public JobDay jobDay() {return jobDay;}

	public static Model getInstance() {
		if (Instance == null) {
			Instance = new Model();
		}
		return Instance;
	}
}
