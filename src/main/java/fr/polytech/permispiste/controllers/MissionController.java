package fr.polytech.permispiste.controllers;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.Goal;
import fr.polytech.permispiste.entities.Mission;
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
		return SERIALIZER.toT(this.missionDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.missionDaoServices.getAll());
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.toT(new CounterReport(this.missionDaoServices.count()));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "label") String label, @RequestParam(value = "goalIds[]") int[] goalIds) {
		final Mission mission = new Mission();
		mission.setLabel(label);
		mission.setGoals(new HashSet<Goal>(this.goalDaoServices.getAllIn(Arrays.asList(goalIds))));

		this.missionDaoServices.insert(mission);
		return SERIALIZER.toT(mission);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "label") String label, @RequestParam(value = "goalIds[]") int[] goalIds) {
		final Mission mission = this.missionDaoServices.get(id);
		mission.setLabel(label);
		mission.setGoals(new HashSet<Goal>(this.goalDaoServices.getAllIn(Arrays.asList(goalIds))));

		this.missionDaoServices.update(mission);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.missionDaoServices.delete(this.missionDaoServices.get(id));
	}
}