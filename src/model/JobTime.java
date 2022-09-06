package model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Model for Time
 * Keep the time for cleaning job
 * @author Soonyoung Park
 *
 */
public class JobTime {

	private LocalTime now = LocalTime.now();
	private LocalTime time = now;
	private int hour = now.getHour();
	private int minute = now.getMinute();

	public void updateTime(int hour, int minute) {
		time = LocalTime.of(hour, minute);
		this.hour = hour;
		this.minute = minute;
	}
	
	public LocalTime getTime() {
		return time.truncatedTo(ChronoUnit.MINUTES);
	}
	
	public String getString() {
		return Integer.toString(hour) +":"+Integer.toString(minute);
	}

}
