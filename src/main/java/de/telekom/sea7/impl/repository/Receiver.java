package de.telekom.sea7.impl.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receiver {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	private String name;
	private String street;
	private String city;
	private String zipcode;
	private String country;
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
