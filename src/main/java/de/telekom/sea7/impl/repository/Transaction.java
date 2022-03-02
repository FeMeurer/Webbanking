package de.telekom.sea7.impl.repository;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
//	@NotNull
	private float amount;
	
//	@NotNull
	private String receiver; 
	
//	@NotNull
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="iban_id")
	private Iban iban;
	
//	@NotNull
	private String purpose;
	
//	@NotNull
	private LocalDateTime creationdate;
	
	public long getId() {
		return id;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public String getReceiver() {
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
	
	public void setId(long id) {
		this.id = id;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public void setReceiver(String receiver) {
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
