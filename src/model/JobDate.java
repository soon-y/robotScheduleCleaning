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

	public void updateDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Compare date
	 * @return Tomorrow, Today, otherwise dd/mm/yyyy
	 */
	public String getString() {
		if (date.equals(today.plusDays(1))) {
			return "Tomorrow";
		}
		else if(date.equals(today)){
			return "Today";
		}else {
			String mm = Integer.toString(date.getMonthValue());
			String yy = Integer.toString(date.getYear());
			String dd = Integer.toString(date.getDayOfMonth());
			return dd +"/"+ mm +"/"+ yy;
		}
	}

}
