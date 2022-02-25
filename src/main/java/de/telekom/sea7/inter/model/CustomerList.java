package de.telekom.sea7.inter.model;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

public interface CustomerList {

	Iterator<Customer> iterator();

	List<Customer> getCustomerList();

	void setCustomerList(List<Customer> customerList);

	Customer get(int index);

	int size();

	int indexOf(Customer customer);

	void add(Customer customer);

	void clear();

	void remove(int index);

	void init();

}