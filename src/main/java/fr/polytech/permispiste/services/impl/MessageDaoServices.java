package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Message;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a message DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MessageDaoServices extends AbstractDaoServices<Message> {

	public MessageDaoServices() {
		super(Message.class);
	}

	@Override
	public String getTableName() {
		return "messages";
	}
}