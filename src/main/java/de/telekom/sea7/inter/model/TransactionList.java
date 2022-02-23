package de.telekom.sea7.inter.model;

import java.util.Iterator;
import java.util.List;

public interface TransactionList extends Iterable<Transaction> {

	Iterator<Transaction> iterator();

	List<Transaction> getTransactionList();

	void setTransactionList(List<Transaction> transactionList);

	int size();

	int indexOf(Transaction transaction);
	
	void add(Transaction transaction);
	
	void clear();
	
	Transaction get(int index);

	void remove(int index);
}