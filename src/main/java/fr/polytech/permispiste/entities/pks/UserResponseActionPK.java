package fr.polytech.permispiste.entities.pks;

import java.io.Serializable;

import fr.polytech.permispiste.entities.Action;
import fr.polytech.permispiste.entities.Goal;
import fr.polytech.permispiste.entities.Mission;
import fr.polytech.permispiste.entities.Paper;
import fr.polytech.permispiste.entities.Training;
import fr.polytech.permispiste.entities.User;

public class UserResponseActionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;

	private Training training;

	private Paper paper;

	private Mission mission;

	private Goal goal;

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