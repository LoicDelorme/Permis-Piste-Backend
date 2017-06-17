package fr.polytech.permispiste.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Action;
import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.requests.ActionForm;
import fr.polytech.permispiste.responses.SuccessResponse;
import fr.polytech.permispiste.services.impl.ActionDaoServices;

/**
 * This class represents an action controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/action")
public class ActionController extends AbstractController {

	private final ActionDaoServices actionDaoServices;

	public ActionController() {
		this.actionDaoServices = new ActionDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.to(new SuccessResponse(this.actionDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.to(new SuccessResponse(this.actionDaoServices.getAll()));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.actionDaoServices.count())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final ActionForm actionForm = DESERIALIZER.from(data, ActionForm.class);

		final Action action = new Action();
		action.setLabel(actionForm.getLabel());

		this.actionDaoServices.insert(action);
		return SERIALIZER.to(new SuccessResponse(action));
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody String data) {
		final ActionForm actionForm = DESERIALIZER.from(data, ActionForm.class);

		final Action action = this.actionDaoServices.get(id);
		action.setLabel(actionForm.getLabel());

		this.actionDaoServices.update(action);
		return SERIALIZER.to(new SuccessResponse(action));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.actionDaoServices.delete(this.actionDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}