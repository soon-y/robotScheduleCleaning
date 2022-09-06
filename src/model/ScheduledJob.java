package model;

import java.util.ArrayList;

/**
 * Add LinkedList(savedJob) to ArrayList
 * Keep all the scheduled cleaning jobs
 * @author Soonyoung Park
 *
 */
public class ScheduledJob {
	private JobLabel joblabel;
	private JobTime jobTime;
	private JobDate jobDate;
	private JobDay jobDay;
	private JobArea jobArea;
	private Model model;
	private SavedJob saved;

	private ArrayList<SavedJob> scheduledJob;

	private static ScheduledJob Instance = null;

	private ScheduledJob(){
		model = Model.getInstance();
		joblabel = model.jobLabel();
		jobTime = model.jobTime();
		jobDate = model.jobDate();
		jobDay = model.jobDay();
		jobArea = model.jobArea();
		scheduledJob = new ArrayList<>();
	}

	public SavedJob saved() {return saved;}

	/**
	 * instantiate a LinkList
	 * add it to ArrayList
	 */
	public void insert() {
		String label = joblabel.getString();
		String hr = Integer.toString(jobTime.getTime().getHour());
		String min = Integer.toString(jobTime.getTime().getMinute());
		String day = " ";
		// if Repeated Day is set, Date is empty
		if(jobDay.getString()!=null) { day = jobDay.getStringTree(); }
		String dateStr = jobDay.getString();
		String date = " ";
		String month = " ";
		String year = " ";
		// if Date is set, Repeated Day is empty
		if(jobDate.getDate()!=null) {
			dateStr = " ";
			date = Integer.toString(jobDate.getDate().getDayOfMonth());
			month = Integer.toString(jobDate.getDate().getMonthValue());
			year = Integer.toString(jobDate.getDate().getYear());
		}
		String area = jobArea.getString();
		
		//instantiate SavedJob; insert Data into LinkedList
		saved = new SavedJob(label,hr,min,day,dateStr,date,month,year,area);
		
		//add LinkedList to ArrayList
		scheduledJob.add(saved);

	}	
	
	/**
	 * clear LinkedList
	 */
	public void clear() { 
		saved.clear();
	}
	
	public boolean isEmpty() {
		return scheduledJob.isEmpty();
	}
	
	public int size() {
		return scheduledJob.size();
	}
	
	public String get(int index, int savedIndex) {
		return scheduledJob.get(index).get(savedIndex);
	}
	
	public void remove(int currentIndex) {
		scheduledJob.remove(currentIndex);
	}

	public static ScheduledJob getInstance() {
		if (Instance == null) {
			Instance = new ScheduledJob();
		}
		return Instance;

	}
}


