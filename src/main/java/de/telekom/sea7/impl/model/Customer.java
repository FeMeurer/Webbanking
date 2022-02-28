package de.telekom.sea7.impl.model;

import org.springframework.stereotype.Service;

public class Customer {
	
	private int id;
	private String username;
	private String name;
	private String surname;
	
	
	public int getId() {
		return id;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getSurname() {
		return surname;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
