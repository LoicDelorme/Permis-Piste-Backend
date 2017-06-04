package fr.polytech.permispiste.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Paper;
import fr.polytech.permispiste.entities.Rule;
import fr.polytech.permispiste.entities.Training;
import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.services.impl.PaperDaoServices;
import fr.polytech.permispiste.services.impl.RuleDaoServices;
import fr.polytech.permispiste.services.impl.TrainingDaoServices;
import fr.polytech.permispiste.services.impl.UserDaoServices;

/**
 * This class represents a training controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@RestController
@RequestMapping("/training")
public class TrainingController extends AbstractController {

	private final TrainingDaoServices trainingDaoServices;

	private final UserDaoServices userDaoServices;

	private final PaperDaoServices paperDaoServices;

	private final RuleDaoServices ruleDaoServices;

	public TrainingController() {
		this.trainingDaoServices = new TrainingDaoServices();
		this.userDaoServices = new UserDaoServices();
		this.paperDaoServices = new PaperDaoServices();
		this.ruleDaoServices = new RuleDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.toT(this.trainingDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.trainingDaoServices.getAll());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "label") String label, @RequestParam(value = "description") String description, @RequestParam(value = "imagePath") String imagePath, @RequestParam(value = "userIds[]") int[] userIds, @RequestParam(value = "paperIds[]") int[] paperIds, @RequestParam(value = "ruleIds[]") int[] ruleIds) {
		final Set<User> users = new HashSet<User>();
		for (int userId : userIds) {
			users.add(this.userDaoServices.get(userId));
		}

		final Set<Paper> papers = new HashSet<Paper>();
		for (int paperId : paperIds) {
			papers.add(this.paperDaoServices.get(paperId));
		}

		final Set<Rule> rules = new HashSet<Rule>();
		for (int ruleId : ruleIds) {
			rules.add(this.ruleDaoServices.get(ruleId));
		}

		final Training training = new Training();
		training.setLabel(label);
		training.setDescription(description);
		training.setImagePath(imagePath);
		training.setUsers(users);
		training.setPapers(papers);
		training.setRules(rules);

		this.trainingDaoServices.insert(training);
		return SERIALIZER.toT(training);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "label") String label, @RequestParam(value = "description") String description, @RequestParam(value = "imagePath") String imagePath, @RequestParam(value = "userIds[]") int[] userIds, @RequestParam(value = "paperIds[]") int[] paperIds, @RequestParam(value = "ruleIds[]") int[] ruleIds) {
		final Set<User> users = new HashSet<User>();
		for (int userId : userIds) {
			users.add(this.userDaoServices.get(userId));
		}

		final Set<Paper> papers = new HashSet<Paper>();
		for (int paperId : paperIds) {
			papers.add(this.paperDaoServices.get(paperId));
		}

		final Set<Rule> rules = new HashSet<Rule>();
		for (int ruleId : ruleIds) {
			rules.add(this.ruleDaoServices.get(ruleId));
		}

		final Training training = this.trainingDaoServices.get(id);
		training.setLabel(label);
		training.setDescription(description);
		training.setImagePath(imagePath);
		training.setUsers(users);
		training.setPapers(papers);
		training.setRules(rules);

		this.trainingDaoServices.update(training);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.trainingDaoServices.delete(this.trainingDaoServices.get(id));
	}
}