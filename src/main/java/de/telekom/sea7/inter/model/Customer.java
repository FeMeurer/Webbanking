package de.telekom.sea7.inter.model;

public interface Customer {

	String getId();

	String getUsername();

	String getName();

	String getSurname();

	TransactionList getTransactionList();

	void setId(String id);

	void setUsername(String username);

	void setName(String name);

	void setSurname(String surname);

	void setTransactionList(TransactionList transactionList);

}