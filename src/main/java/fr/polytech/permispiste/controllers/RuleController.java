package fr.polytech.permispiste.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.Rule;
import fr.polytech.permispiste.services.impl.RuleDaoServices;

/**
 * This class represents a rule controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/rule")
public class RuleController extends AbstractController {

	private final RuleDaoServices ruleDaoServices;

	public RuleController() {
		this.ruleDaoServices = new RuleDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.toT(this.ruleDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.ruleDaoServices.getAll());
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.toT(new CounterReport(this.ruleDaoServices.count()));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "label") String label, @RequestParam(value = "minimalScore") int minimalScore) {
		final Rule rule = new Rule();
		rule.setLabel(label);
		rule.setMinimalScore(minimalScore);

		this.ruleDaoServices.insert(rule);
		return SERIALIZER.toT(rule);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "label") String label, @RequestParam(value = "minimalScore") int minimalScore) {
		final Rule rule = this.ruleDaoServices.get(id);
		rule.setLabel(label);
		rule.setMinimalScore(minimalScore);

		this.ruleDaoServices.update(rule);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.ruleDaoServices.delete(this.ruleDaoServices.get(id));
	}
}