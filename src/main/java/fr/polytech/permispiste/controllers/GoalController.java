package fr.polytech.permispiste.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Action;
import fr.polytech.permispiste.entities.Goal;
import fr.polytech.permispiste.services.impl.ActionDaoServices;
import fr.polytech.permispiste.services.impl.GoalDaoServices;

/**
 * This class represents a goal controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@RestController
@RequestMapping("/goal")
public class GoalController extends AbstractController {

	private final GoalDaoServices goalDaoServices;

	private final ActionDaoServices actionDaoServices;

	public GoalController() {
		this.goalDaoServices = new GoalDaoServices();
		this.actionDaoServices = new ActionDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.toT(this.goalDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.goalDaoServices.getAll());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "label") String label, @RequestParam(value = "actionIds[]") int[] actionIds) {
		final Set<Action> actions = new HashSet<Action>();
		for (int actionId : actionIds) {
			actions.add(this.actionDaoServices.get(actionId));
		}

		final Goal goal = new Goal();
		goal.setLabel(label);
		goal.setActions(actions);

		this.goalDaoServices.insert(goal);
		return SERIALIZER.toT(goal);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "label") String label, @RequestParam(value = "actionIds[]") int[] actionIds) {
		final Set<Action> actions = new HashSet<Action>();
		for (int actionId : actionIds) {
			actions.add(this.actionDaoServices.get(actionId));
		}

		final Goal goal = this.goalDaoServices.get(id);
		goal.setLabel(label);
		goal.setActions(actions);

		this.goalDaoServices.update(goal);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.goalDaoServices.delete(this.goalDaoServices.get(id));
	}
}