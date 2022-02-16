package de.telekom.sea7.impl.model;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Service
public class TransactionListImpl implements Iterable<Transaction>, TransactionList {

	private List<Transaction> transactionList;
	
	public TransactionListImpl() {}
	
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
	
}
