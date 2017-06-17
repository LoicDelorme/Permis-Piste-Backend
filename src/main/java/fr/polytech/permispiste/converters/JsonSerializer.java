package fr.polytech.permispiste.converters;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * This class represents a JSON serializer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JsonSerializer implements Serializer<String> {

	public static final Jsonb JSON_BUILDER = JsonbBuilder.create();

	@Override
	public String toT(Object obj) {
		return JSON_BUILDER.toJson(obj);
	}
}