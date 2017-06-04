package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.TrainingAction;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a training action DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class TrainingActionDaoServices extends AbstractDaoServices<TrainingAction> {

	public TrainingActionDaoServices() {
		super(TrainingAction.class);
	}
}