package fr.polytech.permispiste.requests;

/**
 * This class represents a goal form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class GoalForm {

	private String label;

	private Integer[] answersIds;

	private Integer responseId;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer[] getAnswersIds() {
		return this.answersIds;
	}

	public void setAnswersIds(Integer[] answersIds) {
		this.answersIds = answersIds;
	}

	public Integer getResponseId() {
		return this.responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}
}