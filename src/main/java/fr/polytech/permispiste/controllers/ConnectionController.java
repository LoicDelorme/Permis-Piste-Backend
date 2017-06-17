package fr.polytech.permispiste.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Token;
import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.services.impl.TokenDaoServices;
import fr.polytech.permispiste.services.impl.UserDaoServices;

/**
 * This class represents a connection controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/connection")
public class ConnectionController extends AbstractController {

	private final UserDaoServices userDaoServices;

	private final TokenDaoServices tokenDaoServices;

	public ConnectionController() {
		this.userDaoServices = new UserDaoServices();
		this.tokenDaoServices = new TokenDaoServices();
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
		final List<User> users = this.userDaoServices.getAll().stream().filter(user -> user.getEmail().equals(email)).collect(Collectors.toList());
		if (users.size() != 1) {
			throw new RuntimeException();
		}

		final Token token = new Token();
		token.setUser(users.get(0));
		token.setBegin(LocalDateTime.now());
		token.setEnd(LocalDateTime.now().plusHours(3));

		this.tokenDaoServices.insert(token);
		return SERIALIZER.to(token);
	}
}