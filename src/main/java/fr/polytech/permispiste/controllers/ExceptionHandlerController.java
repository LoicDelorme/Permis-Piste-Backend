package fr.polytech.permispiste.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.polytech.permispiste.responses.ErrorResponse;

/**
 * This class represents an exception handler controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionHandlerController extends AbstractController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletRequest request, Exception exception) {
		final Writer writer = new StringWriter();
		exception.printStackTrace(new PrintWriter(writer));
		final String exceptionStackTrace = writer.toString();
		final String body = SERIALIZER.to(new ErrorResponse(String.format("Request '%s' raised an exception:\n%s", request.getRequestURL(), exceptionStackTrace)));

		LOGGER.error(exceptionStackTrace);
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}