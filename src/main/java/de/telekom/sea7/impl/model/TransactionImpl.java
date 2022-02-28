package de.telekom.sea7.impl.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.telekom.sea7.inter.model.Transaction;

@Entity
public class TransactionImpl implements Transaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	
	private float amount;
	private int receiver_ID; 
	private int iban_ID;
	private String bic;	
	private String purpose;
	private LocalDateTime creationDate;
	
	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public float getAmount() {
		return amount;
	}
	
	@Override
	public int getReceiver_ID() {
		return receiver_ID;
	}
	
	@Override
	public int getIban_ID() {
		return iban_ID;
	}
	
	@Override
	public String getBic() {
		return bic;
	}
	
	@Override
	public String getPurpose() {
		return purpose;
	}
	
	
	@Override
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	@Override
	public void setID(int iD) {
		ID = iD;
	}
	
	@Override
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public void setReceiver_ID(int receiver_ID) {
		this.receiver_ID = receiver_ID;
	}
	
	@Override
	public void setIban_ID(int iban_ID) {
		this.iban_ID = iban_ID;
	}
	
	@Override
	public void setBic(String bic) {
		this.bic = bic;
	}

	@Override
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	

	
	
}
