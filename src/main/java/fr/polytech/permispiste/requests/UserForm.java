package fr.polytech.permispiste.requests;

/**
 * This class represents a user form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class UserForm {

	private String lastname;

	private String firstname;

	private String email;

	private String password;

	private boolean enabled;

	private boolean administrator;

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

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

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
}