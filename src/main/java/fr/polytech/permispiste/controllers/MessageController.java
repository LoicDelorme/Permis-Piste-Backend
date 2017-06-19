package fr.polytech.permispiste.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.Message;
import fr.polytech.permispiste.requests.MessageForm;
import fr.polytech.permispiste.responses.SuccessResponse;
import fr.polytech.permispiste.services.impl.MessageDaoServices;
import fr.polytech.permispiste.services.impl.UserDaoServices;

/**
 * This class represents a message controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/message")
public class MessageController extends AbstractController {

	private final MessageDaoServices messageDaoServices;

	private final UserDaoServices userDaoServices;

	public MessageController() {
		this.messageDaoServices = new MessageDaoServices();
		this.userDaoServices = new UserDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.to(new SuccessResponse(this.messageDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all(@RequestBody String data) {
		final MessageForm messageForm = DESERIALIZER.from(data, MessageForm.class);
		return SERIALIZER.to(new SuccessResponse(this.messageDaoServices.getByUser(messageForm.getUserId())));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count(@RequestBody String data) {
		final MessageForm messageForm = DESERIALIZER.from(data, MessageForm.class);
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.messageDaoServices.getByUser(messageForm.getUserId()).size())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final MessageForm messageForm = DESERIALIZER.from(data, MessageForm.class);

		final Message message = new Message();
		message.setSubject(message.getSubject());
		message.setBody(messageForm.getBody());
		message.setDate(LocalDateTime.now());
		message.setRead(false);
		message.setUser(this.userDaoServices.get(messageForm.getUserId()));

		this.messageDaoServices.insert(message);
		return SERIALIZER.to(new SuccessResponse(message));
	}

	@RequestMapping(value = "/read/{id}", method = RequestMethod.POST)
	public String read(@PathVariable int id) {
		final Message message = this.messageDaoServices.get(id);
		message.setRead(true);

		this.messageDaoServices.update(message);
		return SERIALIZER.to(new SuccessResponse(message));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.messageDaoServices.delete(this.messageDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}