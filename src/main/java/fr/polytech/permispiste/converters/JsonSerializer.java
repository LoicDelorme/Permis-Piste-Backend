package fr.polytech.permispiste.converters;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonSerializer implements Serializer<String> {

	public final static Jsonb JSON_BUILDER = JsonbBuilder.create();

	@Override
	public String toT(Object obj) {
		return JSON_BUILDER.toJson(obj);
	}
}