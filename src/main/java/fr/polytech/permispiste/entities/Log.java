package fr.polytech.permispiste.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a log entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "logs")
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "date")
	private LocalDateTime date;

	@NotNull
	@Column(name = "ip_address")
	private String ipAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}