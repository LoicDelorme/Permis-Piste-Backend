package fr.polytech.permispiste.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.services.impl.UserDaoServices;

/**
 * This class represents a user controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController {

	private final UserDaoServices userDaoServices;

	public UserController() {
		this.userDaoServices = new UserDaoServices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id) {
		return SERIALIZER.toT(this.userDaoServices.get(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.toT(this.userDaoServices.getAll());
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.toT(new CounterReport(this.userDaoServices.count()));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value = "lastname") String lastname, @RequestParam(value = "firstname") String firstname, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password, @RequestParam(value = "isEnabled") boolean isEnabled, @RequestParam(value = "isAdministrator") boolean isAdministrator) {
		final User user = new User();
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setEmail(email);
		user.setPassword(password);
		user.setEnabled(isEnabled);
		user.setAdministrator(isAdministrator);

		this.userDaoServices.insert(user);
		return SERIALIZER.toT(user);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestParam(value = "lastname") String lastname, @RequestParam(value = "firstname") String firstname, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password, @RequestParam(value = "isEnabled") boolean isEnabled, @RequestParam(value = "isAdministrator") boolean isAdministrator) {
		final User user = this.userDaoServices.get(id);
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setEmail(email);
		user.setPassword(password);
		user.setEnabled(isEnabled);
		user.setAdministrator(isAdministrator);

		this.userDaoServices.update(user);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		this.userDaoServices.delete(this.userDaoServices.get(id));
	}
}