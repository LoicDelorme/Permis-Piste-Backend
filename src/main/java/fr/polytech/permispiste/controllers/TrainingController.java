package fr.polytech.permispiste.controllers;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.Paper;
import fr.polytech.permispiste.entities.Rule;
import fr.polytech.permispiste.entities.Training;
import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.requests.TrainingForm;
import fr.polytech.permispiste.responses.SuccessResponse;
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
@CrossOrigin
@RestController
@RequestMapping("/api/training")
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
		return SERIALIZER.to(new SuccessResponse(this.trainingDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.to(new SuccessResponse(this.trainingDaoServices.getAll()));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.trainingDaoServices.count())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final TrainingForm trainingForm = DESERIALIZER.from(data, TrainingForm.class);

		final Training training = new Training();
		training.setLabel(trainingForm.getLabel());
		training.setDescription(trainingForm.getDescription());
		training.setImagePath(trainingForm.getImagePath());
		if (trainingForm.getUsersIds().length > 0) {
			training.setUsers(new HashSet<User>(this.userDaoServices.getAllIn(Arrays.asList(trainingForm.getUsersIds()))));
		}
		if (trainingForm.getPapersIds().length > 0) {
			training.setPapers(new HashSet<Paper>(this.paperDaoServices.getAllIn(Arrays.asList(trainingForm.getPapersIds()))));
		}
		if (trainingForm.getRulesIds().length > 0) {
			training.setRules(new HashSet<Rule>(this.ruleDaoServices.getAllIn(Arrays.asList(trainingForm.getRulesIds()))));
		}

		this.trainingDaoServices.insert(training);
		return SERIALIZER.to(new SuccessResponse(training));
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody String data) {
		final TrainingForm trainingForm = DESERIALIZER.from(data, TrainingForm.class);

		final Training training = this.trainingDaoServices.get(id);
		training.setLabel(trainingForm.getLabel());
		training.setDescription(trainingForm.getDescription());
		training.setImagePath(trainingForm.getImagePath());
		if (trainingForm.getUsersIds().length > 0) {
			training.setUsers(new HashSet<User>(this.userDaoServices.getAllIn(Arrays.asList(trainingForm.getUsersIds()))));
		} else {
			training.getUsers().clear();
		}
		if (trainingForm.getPapersIds().length > 0) {
			training.setPapers(new HashSet<Paper>(this.paperDaoServices.getAllIn(Arrays.asList(trainingForm.getPapersIds()))));
		} else {
			training.getPapers().clear();
		}
		if (trainingForm.getRulesIds().length > 0) {
			training.setRules(new HashSet<Rule>(this.ruleDaoServices.getAllIn(Arrays.asList(trainingForm.getRulesIds()))));
		} else {
			training.getRules().clear();
		}

		this.trainingDaoServices.update(training);
		return SERIALIZER.to(new SuccessResponse(training));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.trainingDaoServices.delete(this.trainingDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}