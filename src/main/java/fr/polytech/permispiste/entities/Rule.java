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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * This class represents a rule entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "rules", uniqueConstraints = { @UniqueConstraint(columnNames = "label") })
public class Rule implements Serializable {

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
	@Column(name = "minimal_score")
	private int minimalScore;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "rules")
	private Set<Training> trainings = new HashSet<Training>();

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

	public int getMinimalScore() {
		return this.minimalScore;
	}

	public void setMinimalScore(int minimalScore) {
		this.minimalScore = minimalScore;
	}

	public Set<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
}