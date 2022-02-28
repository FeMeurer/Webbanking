package de.telekom.sea7.inter.model;

import java.time.LocalDateTime;

public interface Transaction {

	int getID();

	float getAmount();

	int getReceiver_ID();

	int getIban_ID();

	String getBic();

	String getPurpose();

	LocalDateTime getCreationDate();

	void setID(int iD);

	void setAmount(float amount);

	void setReceiver_ID(int receiver_ID);

	void setIban_ID(int iban_ID);

	void setBic(String bic);

	void setCreationDate(LocalDateTime creationDate);

	void setPurpose(String purpose);

}