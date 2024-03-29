package fr.polytech.permispiste.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.Rule;
import fr.polytech.permispiste.requests.RuleForm;
import fr.polytech.permispiste.responses.SuccessResponse;
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
		return SERIALIZER.to(new SuccessResponse(this.ruleDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.to(new SuccessResponse(this.ruleDaoServices.getAll()));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.ruleDaoServices.count())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final RuleForm ruleForm = DESERIALIZER.from(data, RuleForm.class);

		final Rule rule = new Rule();
		rule.setLabel(ruleForm.getLabel());
		rule.setMinimalScore(ruleForm.getMinimalScore());

		this.ruleDaoServices.insert(rule);
		return SERIALIZER.to(new SuccessResponse(rule));
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody String data) {
		final RuleForm ruleForm = DESERIALIZER.from(data, RuleForm.class);

		final Rule rule = this.ruleDaoServices.get(id);
		rule.setLabel(ruleForm.getLabel());
		rule.setMinimalScore(ruleForm.getMinimalScore());

		this.ruleDaoServices.update(rule);
		return SERIALIZER.to(new SuccessResponse(rule));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.ruleDaoServices.delete(this.ruleDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}