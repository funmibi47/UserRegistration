package com.userreg.web.Model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_reg")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=45)
	private String fullname;
	 
	
	@Column(nullable=false, unique=true, length=45)
	private String email;
	 
	@Column(nullable=false , length=14)
	private long phone;
	 
	@Column(nullable=false , length=64)
	private String password;
	
	@Column(nullable=false , length=64)
	private String activation_token;
	
	@Column(nullable=false , length=10)
	private boolean active;
	
	public String getActivation_token() {
		return activation_token;
	}
	public void setActivation_token(String activation_token) {
		this.activation_token = activation_token;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 
	
	
	

}
