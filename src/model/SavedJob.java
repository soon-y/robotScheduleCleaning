package model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Add all the data into a LinkedList
 * @author Soonyoung Park
 *
 */
public class SavedJob {

	private LinkedList<String> oneJob;
	
	public LinkedList job() {return oneJob;}
	
	public SavedJob(String label, String hr, String min, String day, 
			String dateStr, String date, String month, String year, String area){
		oneJob = new LinkedList<>();	
		add(label);
		add(hr);
		add(min);
		add(day);
		add(dateStr);
		add(date);
		add(month);
		add(year);
		add(area);
	
	}
	
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < oneJob.size();
			}
			
			@Override
			public String next() {				
				String data = oneJob.get(index);
				index++;
				return data;				
			}			
		};
	}
	
	public void add(String data) {
		oneJob.add(data);
	}
	
	public boolean contains(String v) {
		return oneJob.contains(v);
	}

	public String get(int currentIndex) {
		return oneJob.get(currentIndex);
	}

	public int size() {
		return oneJob.size();
	}
	
	public void clear() {
		oneJob.clear();
	}
	
}







