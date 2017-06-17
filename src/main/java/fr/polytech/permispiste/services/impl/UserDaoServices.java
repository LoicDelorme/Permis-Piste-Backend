package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a user DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class UserDaoServices extends AbstractDaoServices<User> {

	public UserDaoServices() {
		super(User.class);
	}
}