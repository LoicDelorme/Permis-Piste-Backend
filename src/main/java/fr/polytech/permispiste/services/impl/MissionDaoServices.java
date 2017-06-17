package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Mission;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a mission DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MissionDaoServices extends AbstractDaoServices<Mission> {

	public MissionDaoServices() {
		super(Mission.class);
	}

	@Override
	public String getTableName() {
		return "missions";
	}
}