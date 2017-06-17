package fr.polytech.permispiste.responses;

/**
 * This class represents a success response.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SuccessResponse extends AbstractResponse {

	public SuccessResponse() {
		this(null);
	}

	public SuccessResponse(Object data) {
		super(true, data);
	}
}