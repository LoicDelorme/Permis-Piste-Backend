package fr.polytech.permispiste.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.polytech.permispiste.entities.pks.UserResponseActionPK;

/**
 * This class represents a user action entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@IdClass(UserResponseActionPK.class)
@Table(name = "users_responses_actions")
public class UserResponseAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "training")
	private Training training;

	@Id
	@ManyToOne
	@JoinColumn(name = "paper")
	private Paper paper;

	@Id
	@ManyToOne
	@JoinColumn(name = "mission")
	private Mission mission;

	@Id
	@ManyToOne
	@JoinColumn(name = "goal")
	private Goal goal;

	@Id
	@ManyToOne
	@JoinColumn(name = "action")
	private Action action;

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
}