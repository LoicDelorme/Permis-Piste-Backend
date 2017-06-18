package fr.polytech.permispiste.requests;

/**
 * This class represents an authentification form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class AuthentificationForm {

	private String email;

	private String password;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}