package fr.polytech.permispiste.requests;

/**
 * This class represents a rule form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class RuleForm {

	private String label;

	private int minimalScore;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getMinimalScore() {
		return this.minimalScore;
	}

	public void setMinimalScore(int minimalScore) {
		this.minimalScore = minimalScore;
	}
}