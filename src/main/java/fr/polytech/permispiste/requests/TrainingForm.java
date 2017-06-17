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

	private Integer[] usersIds;

	private Integer[] papersIds;

	private Integer[] rulesIds;

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

	public Integer[] getUsersIds() {
		return this.usersIds;
	}

	public void setUsersIds(Integer[] usersIds) {
		this.usersIds = usersIds;
	}

	public Integer[] getPapersIds() {
		return this.papersIds;
	}

	public void setPapersIds(Integer[] papersIds) {
		this.papersIds = papersIds;
	}

	public Integer[] getRulesIds() {
		return this.rulesIds;
	}

	public void setRulesIds(Integer[] rulesIds) {
		this.rulesIds = rulesIds;
	}
}