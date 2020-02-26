package com.br.userbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.br.userbook.model.User;

@Entity
@Table(name = "phones")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@NotNull(message = "DDD cannot be null")
	@NotEmpty(message = "DDD cannot be empty")
	@Pattern(regexp = "[0-9]*", message = "DDD has invalid characters")
	@Size(min = 2, max = 2, message = "DDD must have only 2 numbers")
	@Column(nullable = false, length = 2)
	private int ddd;
	
	@NotNull(message = "Phone number cannot be null")
	@NotEmpty(message = "Phone number cannot be empty")
	@Pattern(regexp = "[0-9]*", message = "Phone number has invalid characters")
	@Size(min = 8, max = 9, message = "Phone number must have between 8 and 9 numbers")
	@Column(nullable = false, unique = true, length = 9)
	private String number;
	
	@NotNull(message = "Phone type cannot be null")
	@NotEmpty(message = "Phone type cannot be empty")
	@Column(nullable = false, length = 20)
	private String type;

	public Phone() {

	}

	public Phone(User user, int ddd, String number, String type) {
		this.user = user;
		this.ddd = ddd;
		this.number = number;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
