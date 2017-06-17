package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Goal;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a goal DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class GoalDaoServices extends AbstractDaoServices<Goal> {

	public GoalDaoServices() {
		super(Goal.class);
	}

	@Override
	public String getTableName() {
		return "goals";
	}
}