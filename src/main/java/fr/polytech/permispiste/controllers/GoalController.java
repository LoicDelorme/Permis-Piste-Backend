package fr.polytech.permispiste.controllers;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Action;
import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.Goal;
import fr.polytech.permispiste.requests.GoalForm;
import fr.polytech.permispiste.responses.SuccessResponse;
import fr.polytech.permispiste.services.impl.ActionDaoServices;
import fr.polytech.permispiste.services.impl.GoalDaoServices;

/**
 * This class represents a goal controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/goal")
public class GoalController extends AbstractController {

	private final GoalDaoServices goalDaoServices;

	private final ActionDaoServices actionDaoServices;

	public GoalController() {
		this.goalDaoServices = new GoalDaoServices();
		this.actionDaoServices = new ActionDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.to(new SuccessResponse(this.goalDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.to(new SuccessResponse(this.goalDaoServices.getAll()));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.goalDaoServices.count())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final GoalForm goalForm = DESERIALIZER.from(data, GoalForm.class);

		final Goal goal = new Goal();
		goal.setLabel(goalForm.getLabel());
		if (goalForm.getIds().length > 0) {
			goal.setActions(new HashSet<Action>(this.actionDaoServices.getAllIn(Arrays.asList(goalForm.getIds()))));
		}

		this.goalDaoServices.insert(goal);
		return SERIALIZER.to(new SuccessResponse(goal));
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody String data) {
		final GoalForm goalForm = DESERIALIZER.from(data, GoalForm.class);

		final Goal goal = this.goalDaoServices.get(id);
		goal.setLabel(goalForm.getLabel());
		if (goalForm.getIds().length > 0) {
			goal.setActions(new HashSet<Action>(this.actionDaoServices.getAllIn(Arrays.asList(goalForm.getIds()))));
		} else {
			goal.getActions().clear();
		}

		this.goalDaoServices.update(goal);
		return SERIALIZER.to(new SuccessResponse(goal));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.goalDaoServices.delete(this.goalDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}