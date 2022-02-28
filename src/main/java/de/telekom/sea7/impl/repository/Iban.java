package de.telekom.sea7.impl.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Iban {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	private String iban;
	private int bic_ID;
	
	public int getID() {
		return ID;
	}
	
	public String getIban() {
		return iban;
	}
	
	public int getBic_ID() {
		return bic_ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public void setBic_ID(int bic_ID) {
		this.bic_ID = bic_ID;
	}
}
