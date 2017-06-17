package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Rule;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a rule DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class RuleDaoServices extends AbstractDaoServices<Rule> {

	public RuleDaoServices() {
		super(Rule.class);
	}
}