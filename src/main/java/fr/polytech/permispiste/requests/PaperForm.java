package fr.polytech.permispiste.requests;

/**
 * This class represents a paper form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class PaperForm {

	private String label;

	private Integer[] missionsIds;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer[] getMissionsIds() {
		return this.missionsIds;
	}

	public void setMissionsIds(Integer[] missionsIds) {
		this.missionsIds = missionsIds;
	}
}