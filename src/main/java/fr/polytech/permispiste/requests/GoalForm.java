package fr.polytech.permispiste.requests;

/**
 * This class represents a goal form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class GoalForm {

	private String label;

	private Integer[] ids;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer[] getIds() {
		return this.ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
}