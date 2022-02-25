package de.telekom.sea7.impl.model;

import org.springframework.stereotype.Service;

import de.telekom.sea7.inter.model.Customer;
import de.telekom.sea7.inter.model.TransactionList;

public class CustomerImpl implements Customer {
	
	private int id;
	private String username;
	private String name;
	private String surname;
	private TransactionList transactionList;
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getSurname() {
		return surname;
	}
	
	@Override
	public TransactionList getTransactionList() {
		return transactionList;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public void setTransactionList(TransactionList transactionList) {
		this.transactionList = transactionList;
	}
}
