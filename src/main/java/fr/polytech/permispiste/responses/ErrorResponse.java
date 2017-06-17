package fr.polytech.permispiste.responses;

/**
 * This class represents an error response.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class ErrorResponse extends AbstractResponse {

	public ErrorResponse() {
		this(null);
	}

	public ErrorResponse(Object data) {
		super(false, data);
	}
}