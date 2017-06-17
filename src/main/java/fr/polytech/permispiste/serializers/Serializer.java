package fr.polytech.permispiste.serializers;

/**
 * This interface represents a serializer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface Serializer<O> {

	public <I> O to(I in);
}