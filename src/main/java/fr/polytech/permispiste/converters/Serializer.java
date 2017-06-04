package fr.polytech.permispiste.converters;

/**
 * This interface represents a serializer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface Serializer<T> {

	public T toT(Object obj);
}