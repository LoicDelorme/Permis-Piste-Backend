package fr.polytech.permispiste.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * This class represents an action entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "actions", uniqueConstraints = { @UniqueConstraint(columnNames = "label") })
public class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "label")
	private String label;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "actions")
	private Set<Goal> goals = new HashSet<Goal>();

	@OneToMany(mappedBy = "action")
	private Set<TrainingAction> trainingActions = new HashSet<TrainingAction>();

	@OneToMany(mappedBy = "action")
	private Set<UserAction> userActions = new HashSet<UserAction>();

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(Set<Goal> goals) {
		this.goals = goals;
	}

	public Set<TrainingAction> getTrainingActions() {
		return this.trainingActions;
	}

	public void setTrainingActions(Set<TrainingAction> trainingActions) {
		this.trainingActions = trainingActions;
	}

	public Set<UserAction> getUserActions() {
		return this.userActions;
	}

	public void setUserActions(Set<UserAction> userActions) {
		this.userActions = userActions;
	}
}