package fr.polytech.permispiste.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.polytech.permispiste.deserializers.Deserializer;
import fr.polytech.permispiste.deserializers.JsonDeserializer;
import fr.polytech.permispiste.serializers.JsonSerializer;
import fr.polytech.permispiste.serializers.Serializer;

/**
 * This class represents an abstract controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class AbstractController {

	public static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

	public static final Serializer<String> SERIALIZER = new JsonSerializer();

	public static final Deserializer<String> DESERIALIZER = new JsonDeserializer();
}