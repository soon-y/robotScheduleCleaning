package model;

import java.time.LocalDate;

/**
 * Model for Date
 * Keep which date to plan cleaning
 * @author Soonyoung Park
 *
 */
public class JobDate {
	private LocalDate date = null;
	private LocalDate today = LocalDate.now();
	private String str = null;

	public void updateDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public String getString() {
		updateString();
		return str;
	}

	/**
	 * Compare date
	 * @return Tomorrow, Today, otherwise dd/mm/yyyy
	 */
	public void updateString() {
		if (date.equals(today.plusDays(1))) {
			str = "Tomorrow";
		}
		else if(date.equals(today)){
			str = "Today";
		}else {
			String mm = Integer.toString(date.getMonthValue());
			String yy = Integer.toString(date.getYear());
			String dd = Integer.toString(date.getDayOfMonth());
			str = dd +"/"+ mm +"/"+ yy;
		}
	}
}
