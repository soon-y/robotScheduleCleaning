package model;

/**
 * Model for Label
 * Keep the label for cleaning job
 * @author Soonyoung Park
 *
 */
public class JobLabel{
	private String label = "Label";
	
	public String getString() {
	 	return label;
	}
	
	public void updateString(String label) {
		this.label = label;
	}
	
}
