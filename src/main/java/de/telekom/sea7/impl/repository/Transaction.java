package de.telekom.sea7.impl.repository;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	
	private float amount;
	
	@ManyToOne
	@JoinColumn(name="receiver_ID")
	@JsonBackReference
	private Receiver receiver; 
	
	@ManyToOne
	@JoinColumn(name="iban_ID")
	@JsonBackReference
	private Iban iban;
	
	private String purpose;
	private LocalDateTime creationdate;
	
	public int getID() {
		return ID;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public Receiver getReceiver() {
		return receiver;
	}
	
	public Iban getIban() {
		return iban;
	}
	
	public String getPurpose() {
		return purpose;
	}
	
	public LocalDateTime getCreationdate() {
		return creationdate;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	public void setIban(Iban iban) {
		this.iban = iban;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}
	
	
}
