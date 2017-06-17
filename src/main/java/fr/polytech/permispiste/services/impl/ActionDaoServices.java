package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Action;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents an action DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class ActionDaoServices extends AbstractDaoServices<Action> {

	public ActionDaoServices() {
		super(Action.class);
	}
}