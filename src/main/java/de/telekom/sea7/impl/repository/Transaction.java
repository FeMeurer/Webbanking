package de.telekom.sea7.impl.repository;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	
	private float amount;
	private int receiver_ID; 
	private int iban_ID;
	private String purpose;
	private LocalDateTime creationdate;
	
	public int getID() {
		return ID;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public int getReceiver_ID() {
		return receiver_ID;
	}
	
	public int getIban_ID() {
		return iban_ID;
	}
	
	public String getPurpose() {
		return purpose;
	}
	
	
	public LocalDateTime getCreationDate() {
		return creationdate;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public void setReceiver_ID(int receiver_ID) {
		this.receiver_ID = receiver_ID;
	}
	
	public void setIban_ID(int iban_ID) {
		this.iban_ID = iban_ID;
	}

	public void setCreationDate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
