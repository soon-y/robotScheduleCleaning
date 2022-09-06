package model;

import java.util.TreeMap;

/**
 * Model for repeated Day
 * Keep which day to repeat cleaning
 * @author Soonyoung Park
 *
 */
public class JobDay {
	private String day = null;
	private TreeMap<Integer, String> daysTree = new TreeMap<>();
	
	public TreeMap getTreeMap() {
		return daysTree;		
	}
	
	public String getStringTree() {
		return getTreeMap().values().toString();
	}

	public String getString() {
		return day;
	}

	public void updateString(String day) {
		this.day = day;
	}


}
