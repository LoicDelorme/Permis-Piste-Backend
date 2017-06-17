package fr.polytech.permispiste.deserializers;

/**
 * This interface represents a deserializer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface Deserializer<I> {

	public <O> O from(I in, Class<O> clazz);
}