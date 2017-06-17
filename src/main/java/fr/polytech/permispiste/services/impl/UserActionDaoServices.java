package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.UserAction;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a user action DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class UserActionDaoServices extends AbstractDaoServices<UserAction> {

	public UserActionDaoServices() {
		super(UserAction.class);
	}

	@Override
	public String getTableName() {
		return "users_actions";
	}
}