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
import fr.polytech.permispiste.entities.Goal;
import fr.polytech.permispiste.entities.Mission;
import fr.polytech.permispiste.requests.MissionForm;
import fr.polytech.permispiste.responses.SuccessResponse;
import fr.polytech.permispiste.services.impl.GoalDaoServices;
import fr.polytech.permispiste.services.impl.MissionDaoServices;

/**
 * This class represents a mission controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/mission")
public class MissionController extends AbstractController {

	private final MissionDaoServices missionDaoServices;

	private final GoalDaoServices goalDaoServices;

	public MissionController() {
		this.missionDaoServices = new MissionDaoServices();
		this.goalDaoServices = new GoalDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.to(new SuccessResponse(this.missionDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.to(new SuccessResponse(this.missionDaoServices.getAll()));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.missionDaoServices.count())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final MissionForm missionForm = DESERIALIZER.from(data, MissionForm.class);

		final Mission mission = new Mission();
		mission.setLabel(missionForm.getLabel());
		if (missionForm.getIds().length > 0) {
			mission.setGoals(new HashSet<Goal>(this.goalDaoServices.getAllIn(Arrays.asList(missionForm.getIds()))));
		}

		this.missionDaoServices.insert(mission);
		return SERIALIZER.to(new SuccessResponse(mission));
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody String data) {
		final MissionForm missionForm = DESERIALIZER.from(data, MissionForm.class);

		final Mission mission = this.missionDaoServices.get(id);
		mission.setLabel(missionForm.getLabel());
		if (missionForm.getIds().length > 0) {
			mission.setGoals(new HashSet<Goal>(this.goalDaoServices.getAllIn(Arrays.asList(missionForm.getIds()))));
		} else {
			mission.getGoals().clear();
		}

		this.missionDaoServices.update(mission);
		return SERIALIZER.to(new SuccessResponse(mission));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.missionDaoServices.delete(this.missionDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}