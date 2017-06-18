package fr.polytech.permispiste.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.permispiste.entities.Log;
import fr.polytech.permispiste.entities.Token;
import fr.polytech.permispiste.entities.User;
import fr.polytech.permispiste.requests.AuthentificationForm;
import fr.polytech.permispiste.responses.ErrorResponse;
import fr.polytech.permispiste.responses.SuccessResponse;
import fr.polytech.permispiste.services.impl.LogDaoServices;
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

	private final LogDaoServices logDaoServices;

	public ConnectionController() {
		this.userDaoServices = new UserDaoServices();
		this.tokenDaoServices = new TokenDaoServices();
		this.logDaoServices = new LogDaoServices();
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(HttpServletRequest request, @RequestBody String data) {
		final AuthentificationForm authentificationForm = DESERIALIZER.from(data, AuthentificationForm.class);

		final User user = this.userDaoServices.getByEmail(authentificationForm.getEmail());
		if (!user.getPassword().equals(authentificationForm.getPassword())) {
			return SERIALIZER.to(new ErrorResponse("Invalid credentials"));
		}

		final Token token = new Token();
		token.setUser(user);
		token.setBegin(LocalDateTime.now());
		token.setEnd(LocalDateTime.now().plusHours(6));

		final Log log = new Log();
		log.setUser(user);
		log.setDate(LocalDateTime.now());
		log.setIpAddress(request.getRemoteAddr());

		this.tokenDaoServices.insert(token);
		this.logDaoServices.insert(log);
		return SERIALIZER.to(new SuccessResponse(token));
	}
}