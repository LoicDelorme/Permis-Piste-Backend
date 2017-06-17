package fr.polytech.permispiste.requests;

/**
 * This class represents a training form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class TrainingForm {

	private String label;

	private String description;

	private String imagePath;

	private int[] usersIds;

	private int[] papersIds;

	private int[] rulesIds;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int[] getUsersIds() {
		return this.usersIds;
	}

	public void setUsersIds(int[] usersIds) {
		this.usersIds = usersIds;
	}

	public int[] getPapersIds() {
		return this.papersIds;
	}

	public void setPapersIds(int[] papersIds) {
		this.papersIds = papersIds;
	}

	public int[] getRulesIds() {
		return this.rulesIds;
	}

	public void setRulesIds(int[] rulesIds) {
		this.rulesIds = rulesIds;
	}
}