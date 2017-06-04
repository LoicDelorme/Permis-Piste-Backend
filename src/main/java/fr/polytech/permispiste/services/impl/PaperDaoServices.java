package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Paper;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a paper DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class PaperDaoServices extends AbstractDaoServices<Paper> {

	public PaperDaoServices() {
		super(Paper.class);
	}
}