package fr.polytech.permispiste.responses;

/**
 * This class represents an abstract response.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class AbstractResponse {

	private final boolean success;

	private final Object data;

	public AbstractResponse(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public Object getData() {
		return this.data;
	}
}