package fr.polytech.permispiste.services.impl;

import static fr.polytech.permispiste.sessions.HibernateSessionManager.getSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

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

	public User getByEmail(String email) {
		final Session session = getSession();

		session.beginTransaction();
		final Query<User> query = session.createQuery(String.format("SELECT el FROM %s el WHERE el.email = :email", this.entityClass.getSimpleName()), this.entityClass);
		query.setParameter("email", email);
		final User user = query.getSingleResult();
		session.getTransaction().commit();

		session.close();

		return user;
	}
}