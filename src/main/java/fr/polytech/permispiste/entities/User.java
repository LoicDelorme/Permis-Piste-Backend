package fr.polytech.permispiste.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * This class represents a user entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "lastname")
	private String lastname;

	@NotNull
	@Column(name = "firstname")
	private String firstname;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "is_enabled")
	private boolean isEnabled;

	@NotNull
	@Column(name = "is_administrator")
	private boolean isAdministrator;

	@JsonbTransient
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
	private Set<Training> trainings = new HashSet<Training>();

	@JsonbTransient
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserResponseAction> userResponseActions = new HashSet<UserResponseAction>();

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return this.isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isAdministrator() {
		return this.isAdministrator;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public Set<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	public Set<UserResponseAction> getUserResponseActions() {
		return this.userResponseActions;
	}

	public void setUserResponseActions(Set<UserResponseAction> userResponseActions) {
		this.userResponseActions = userResponseActions;
	}
}