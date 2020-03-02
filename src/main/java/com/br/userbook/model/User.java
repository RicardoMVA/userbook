package com.br.userbook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.br.userbook.model.Phone;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
//	blocks all numbers and non-latin characters
	@Pattern(regexp = "[^0-9]*[^\\P{L}]*", message = "Name contains invalid characters")
	@Size(min = 4, max = 80, message = "Name cannot have less than 4 or more than 80 characters")
	@Column(nullable = false, length = 80)
	private String name;

	@NotNull(message = "Email cannot be null")
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Must be a valid email address")
	@Size(min = 4, max = 80, message = "Email cannot have less than 4 or more than 80 characters")
	@Column(nullable = false, unique = true, length = 80)
	private String email;

	@NotNull(message = "Password cannot be null")
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 8, max = 80, message = "Password cannot have less than 8 or more than 80 characters")
	@Column(nullable = false, length = 80)
	private String password;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private List<Phone> phones;

	public User() {

	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
