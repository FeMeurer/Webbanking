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
	
	@PostConstruct
	public void init() {
		transactionList = new ArrayList<Transaction>();
		Transaction transaction1 = new TransactionImpl();
		transaction1.setAmount(50.00f);
		transaction1.setReceiver("Rüdiger");
		transaction1.setIban("DE9191");
		transaction1.setBic("BANK01");
		transaction1.setPurpose("Geld");
		transaction1.setDate(LocalDateTime.now());
		transaction1.setId(1);
		transactionList.add(transaction1);

		Transaction transaction2 = new TransactionImpl();
		transaction2.setAmount(20.00f);
		transaction2.setReceiver("Jans");
		transaction2.setIban("DE9191");
		transaction2.setBic("BANK01");
		transaction2.setPurpose("Geld");
		transaction2.setDate(LocalDateTime.now());
		transaction2.setId(2);
		transactionList.add(transaction2);

		Transaction transaction3 = new TransactionImpl();
		transaction3.setAmount(10.00f);
		transaction3.setReceiver("Tanja");
		transaction3.setIban("DE9191");
		transaction3.setBic("BANK01");
		transaction3.setPurpose("Geld");
		transaction3.setDate(LocalDateTime.now());
		transaction3.setId(3);
		transactionList.add(transaction3);
	}	
}
