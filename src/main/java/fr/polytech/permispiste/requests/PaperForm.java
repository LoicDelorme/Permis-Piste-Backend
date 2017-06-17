package fr.polytech.permispiste.requests;

/**
 * This class represents a paper form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class PaperForm {

	private String label;

	private int[] ids;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int[] getIds() {
		return this.ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
}