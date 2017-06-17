package fr.polytech.permispiste.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.CounterReport;
import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.requests.UserForm;
import fr.polytech.permispiste.responses.SuccessResponse;
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
		return SERIALIZER.to(new SuccessResponse(this.userDaoServices.get(id)));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return SERIALIZER.to(new SuccessResponse(this.userDaoServices.getAll()));
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public String count() {
		return SERIALIZER.to(new SuccessResponse(new CounterReport(this.userDaoServices.count())));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		final UserForm userForm = DESERIALIZER.from(data, UserForm.class);

		final User user = new User();
		user.setLastname(userForm.getLastname());
		user.setFirstname(userForm.getFirstname());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setEnabled(userForm.isEnabled());
		user.setAdministrator(userForm.isAdministrator());

		this.userDaoServices.insert(user);
		return SERIALIZER.to(new SuccessResponse(user));
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable int id, @RequestBody String data) {
		final UserForm userForm = DESERIALIZER.from(data, UserForm.class);

		final User user = this.userDaoServices.get(id);
		user.setLastname(userForm.getLastname());
		user.setFirstname(userForm.getFirstname());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setEnabled(userForm.isEnabled());
		user.setAdministrator(userForm.isAdministrator());

		this.userDaoServices.update(user);
		return SERIALIZER.to(new SuccessResponse(user));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		this.userDaoServices.delete(this.userDaoServices.get(id));
		return SERIALIZER.to(new SuccessResponse());
	}
}