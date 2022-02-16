package de.telekom.sea7.impl.model;

import java.time.LocalDateTime;

public interface Transaction {

	float getAmount();

	String getReceiver();

	String getIban();

	String getBic();

	String getPurpose();

	LocalDateTime getDate();

	void setAmount(float amount);

	void setReceiver(String receiver);

	void setIban(String iban);

	void setBic(String bic);

	void setPurpose(String purpose);

	void setDate(LocalDateTime date);

}