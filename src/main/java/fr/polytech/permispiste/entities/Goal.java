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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * This class represents a goal entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "goals", uniqueConstraints = { @UniqueConstraint(columnNames = "label") })
public class Goal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "label")
	private String label;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "goals_actions", joinColumns = { @JoinColumn(name = "goal", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "action", nullable = false, updatable = false) })
	private Set<Action> actions = new HashSet<Action>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "action")
	private Action action;

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

	public Set<Action> getActions() {
		return this.actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}