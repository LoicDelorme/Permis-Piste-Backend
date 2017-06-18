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

	private int responseId;

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

	public int getResponseId() {
		return this.responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
}