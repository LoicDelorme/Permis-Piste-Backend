package fr.polytech.permispiste.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Action;
import fr.polytech.permispiste.entities.CounterReport;
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
		return SERIALIZER.toT(this.actionDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.actionDaoServices.getAll());
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.toT(new CounterReport(this.actionDaoServices.count()));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "label") String label) {
		final Action action = new Action();
		action.setLabel(label);

		this.actionDaoServices.insert(action);
		return SERIALIZER.toT(action);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "label") String label) {
		final Action action = this.actionDaoServices.get(id);
		action.setLabel(label);

		this.actionDaoServices.update(action);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.actionDaoServices.delete(this.actionDaoServices.get(id));
	}
}