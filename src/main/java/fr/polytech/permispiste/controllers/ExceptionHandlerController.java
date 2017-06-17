package fr.polytech.permispiste.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.polytech.permispiste.responses.ErrorResponse;

/**
 * This class represents an exception handler controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionHandlerController extends AbstractController {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception exception) {
		final Writer writer = new StringWriter();
		exception.printStackTrace(new PrintWriter(writer));

		final String exceptionStackTrace = writer.toString();
		LOGGER.error(exceptionStackTrace);
		return SERIALIZER.to(new ErrorResponse(String.format("Request \"%s\" raised an exception:\n%s", request.getRequestURL(), exceptionStackTrace)));
	}
}