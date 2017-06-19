package fr.polytech.permispiste.services.impl;

import static fr.polytech.permispiste.sessions.HibernateSessionManager.getSession;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.polytech.permispiste.entities.Message;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a message DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MessageDaoServices extends AbstractDaoServices<Message> {

	public MessageDaoServices() {
		super(Message.class);
	}

	public List<Message> getByUser(Integer userId) {
		final Session session = getSession();

		session.beginTransaction();
		final Query<Message> query = session.createQuery(String.format("SELECT el FROM %s el WHERE el.user = :user", this.entityClass.getSimpleName()), this.entityClass);
		query.setParameter("user", userId);
		final List<Message> messages = query.getResultList();
		session.getTransaction().commit();

		session.close();

		return messages;
	}
}