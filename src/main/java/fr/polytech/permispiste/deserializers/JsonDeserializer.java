package fr.polytech.permispiste.deserializers;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * This class represents a JSON deserializer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JsonDeserializer implements Deserializer<String> {

	public static final Jsonb JSON_BUILDER = JsonbBuilder.create();

	@Override
	public <O> O from(String in, Class<O> clazz) {
		return JSON_BUILDER.fromJson(in, clazz);
	}
}