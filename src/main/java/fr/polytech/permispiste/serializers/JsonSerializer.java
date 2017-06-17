package fr.polytech.permispiste.serializers;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 * This class represents a JSON serializer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JsonSerializer implements Serializer<String> {

	public static final Jsonb JSON_BUILDER = JsonbBuilder.create(new JsonbConfig().withNullValues(true));

	@Override
	public <I> String to(I in) {
		return JSON_BUILDER.toJson(in);
	}
}