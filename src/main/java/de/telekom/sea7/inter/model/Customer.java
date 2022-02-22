package de.telekom.sea7.inter.model;

public interface Customer {

	int getId();

	String getUsername();

	String getName();

	String getSurname();

	TransactionList getTransactionList();

	void setId(int id);

	void setUsername(String username);

	void setName(String name);

	void setSurname(String surname);

	void setTransactionList(TransactionList transactionList);

}