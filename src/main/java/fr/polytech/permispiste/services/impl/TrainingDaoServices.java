package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Training;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a training DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class TrainingDaoServices extends AbstractDaoServices<Training> {

	public TrainingDaoServices() {
		super(Training.class);
	}
}