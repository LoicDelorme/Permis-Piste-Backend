package fr.polytech.permispiste.requests;

/**
 * This class represents a message form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MessageForm {

	private String subject;

	private String body;

	private Integer userId;

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}