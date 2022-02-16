package de.telekom.sea7.impl.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import de.telekom.sea7.inter.model.Transaction;

@Component
public class TransactionImpl implements Transaction {
	
	private float amount;
	private String receiver; 
	private String iban;
	private String bic;	
	private String purpose;
	private LocalDateTime date;
	
	public TransactionImpl() {}

	@Override
	public float getAmount() {
		return amount;
	}

	@Override
	public String getReceiver() {
		return receiver;
	}

	@Override
	public String getIban() {
		return iban;
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
	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Override
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	@Override
	public void setBic(String bic) {
		this.bic = bic;
	}

	@Override
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
