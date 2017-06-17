package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Log;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a log DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class LogDaoServices extends AbstractDaoServices<Log> {

	public LogDaoServices() {
		super(Log.class);
	}

	@Override
	public String getTableName() {
		return "logs";
	}
}