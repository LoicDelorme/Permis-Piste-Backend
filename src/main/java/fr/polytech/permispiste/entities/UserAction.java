package fr.polytech.permispiste.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a user action entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "users_actions")
public class UserAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne
	@JoinColumn(name = "training")
	private Training training;

	@ManyToOne
	@JoinColumn(name = "paper")
	private Paper paper;

	@ManyToOne
	@JoinColumn(name = "mission")
	private Mission mission;

	@ManyToOne
	@JoinColumn(name = "goal")
	private Goal goal;

	@ManyToOne
	@JoinColumn(name = "action")
	private Action action;

	@NotNull
	@Column(name = "offset")
	private int offset;

	@NotNull
	@Column(name = "elasped_time")
	private int elaspedTime;

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Goal getGoal() {
		return this.goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getElaspedTime() {
		return this.elaspedTime;
	}

	public void setElaspedTime(int elaspedTime) {
		this.elaspedTime = elaspedTime;
	}
}