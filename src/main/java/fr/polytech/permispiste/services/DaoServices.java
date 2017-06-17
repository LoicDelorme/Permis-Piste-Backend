package fr.polytech.permispiste.services;

import java.util.List;

/**
 * This interface represents a list of DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface DaoServices<T> {

	public T get(Object id);

	public List<T> getAllIn(List<Integer> ids);

	public List<T> getAll();

	public long count();

	public void insert(T object);

	public void update(T object);

	public void delete(T object);
}