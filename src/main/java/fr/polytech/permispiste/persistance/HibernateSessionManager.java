package fr.polytech.permispiste.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class represents an Hibernate session manager.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class HibernateSessionManager {

	public static final String HIBERNATE_CONFIGURATION_FILE = "hibernate.cfg.xml";

	private static SessionFactory sessionFactory = null;

	private HibernateSessionManager() {
	}

	public static synchronized Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure(HIBERNATE_CONFIGURATION_FILE).buildSessionFactory();
		}

		if (sessionFactory.isOpen()) {
			return sessionFactory.getCurrentSession();
		}

		return sessionFactory.openSession();
	}
}