package fr.polytech.permispiste.services;

import static fr.polytech.permispiste.sessions.HibernateSessionManager.getSession;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

/**
 * This class represents an abstract DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class AbstractDaoServices<T> implements DaoServices<T> {

	private final Class<T> entityClass;

	public AbstractDaoServices(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T get(Object id) {
		final Session session = getSession();

		session.beginTransaction();
		final T entity = session.find(this.entityClass, id);
		session.getTransaction().commit();

		session.close();

		return entity;
	}

	@Override
	public List<T> getAll() {
		final Session session = getSession();

		session.beginTransaction();
		final CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(this.entityClass);
		final List<T> entities = session.createQuery(criteriaQuery.select(criteriaQuery.from(this.entityClass))).getResultList();
		session.getTransaction().commit();

		session.close();

		return entities;
	}

	@Override
	public void insert(T object) {
		final Session session = getSession();

		session.beginTransaction();
		session.saveOrUpdate(object);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void update(T object) {
		final Session session = getSession();

		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void delete(T object) {
		final Session session = getSession();

		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();

		session.close();
	}
}