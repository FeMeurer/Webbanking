package de.telekom.sea7.impl.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.telekom.sea7.impl.model.TransactionImpl;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Service
public class TransactionListImpl implements Iterable<Transaction>, TransactionList {

	private List<Transaction> transactionList;
	
	@Override
	public Iterator<Transaction> iterator() {
		return transactionList.iterator();
	}

	@Override
	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	@Override
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	@Override
	public Transaction get(int index) {
		return this.transactionList.get(index);
	}
	
	@Override
	public int size() {
		return this.transactionList.size();
	}
	
	@Override 
	public int indexOf(Transaction transaction) {
		return this.transactionList.indexOf(transaction);
	}
	
	@Override
	public void add(Transaction transaction) {
		this.transactionList.add(transaction);
	}
	
	@Override
	public void clear() {
		this.transactionList.clear();
	}
	
	public void remove(int index) {
		this.transactionList.remove(index);
	}
}
