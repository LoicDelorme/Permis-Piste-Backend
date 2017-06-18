package fr.polytech.permispiste.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * This class represents a training entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "trainings", uniqueConstraints = { @UniqueConstraint(columnNames = "label") })
public class Training implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "label")
	private String label;

	@NotNull
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "image_path")
	private String imagePath;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "trainings_users", joinColumns = { @JoinColumn(name = "training", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user", nullable = false, updatable = false) })
	private Set<User> users = new HashSet<User>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "trainings_papers", joinColumns = { @JoinColumn(name = "training", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "paper", nullable = false, updatable = false) })
	private Set<Paper> papers = new HashSet<Paper>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "trainings_rules", joinColumns = { @JoinColumn(name = "training", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "rule", nullable = false, updatable = false) })
	private Set<Rule> rules = new HashSet<Rule>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "training")
	private Set<TrainingAction> trainingActions = new HashSet<TrainingAction>();

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

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Paper> getPapers() {
		return this.papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

	public Set<Rule> getRules() {
		return this.rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	public Set<TrainingAction> getTrainingActions() {
		return this.trainingActions;
	}

	public void setTrainingActions(Set<TrainingAction> trainingActions) {
		this.trainingActions = trainingActions;
	}
}