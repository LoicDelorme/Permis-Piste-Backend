package fr.polytech.permispiste.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Mission;
import fr.polytech.permispiste.entities.Paper;
import fr.polytech.permispiste.services.impl.MissionDaoServices;
import fr.polytech.permispiste.services.impl.PaperDaoServices;

/**
 * This class represents a paper controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@RestController
@RequestMapping("/paper")
public class PaperController extends AbstractController {

	private final PaperDaoServices paperDaoServices;

	private final MissionDaoServices missionDaoServices;

	public PaperController() {
		this.paperDaoServices = new PaperDaoServices();
		this.missionDaoServices = new MissionDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.toT(this.paperDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.paperDaoServices.getAll());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "label") String label, @RequestParam(value = "missionIds[]") int[] missionIds) {
		final Set<Mission> missions = new HashSet<Mission>();
		for (int missionId : missionIds) {
			missions.add(this.missionDaoServices.get(missionId));
		}

		final Paper paper = new Paper();
		paper.setLabel(label);
		paper.setMissions(missions);

		this.paperDaoServices.insert(paper);
		return SERIALIZER.toT(paper);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "label") String label, @RequestParam(value = "missionIds[]") int[] missionIds) {
		final Set<Mission> missions = new HashSet<Mission>();
		for (int missionId : missionIds) {
			missions.add(this.missionDaoServices.get(missionId));
		}

		final Paper paper = this.paperDaoServices.get(id);
		paper.setLabel(label);
		paper.setMissions(missions);

		this.paperDaoServices.update(paper);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.paperDaoServices.delete(this.paperDaoServices.get(id));
	}
}