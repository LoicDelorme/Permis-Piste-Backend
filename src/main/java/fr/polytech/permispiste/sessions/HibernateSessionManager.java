package fr.polytech.permispiste.sessions;

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

	public static final String HIBERNATE_CONFIGURATION_FILE = "hibernate.cfg.xml.off";

	private static SessionFactory SESSION_FACTORY = null;

	private HibernateSessionManager() {
	}

	public static synchronized Session getSession() {
		if (SESSION_FACTORY == null) {
			SESSION_FACTORY = new Configuration().configure(HIBERNATE_CONFIGURATION_FILE).buildSessionFactory();
		}

		return SESSION_FACTORY.openSession();
	}
}