package de.telekom.sea7.impl.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.telekom.sea7.impl.model.CustomerImpl;
import de.telekom.sea7.inter.model.Customer;
import de.telekom.sea7.inter.model.CustomerList;

@Service
public class CustomerListImpl implements Iterable<Customer>, CustomerList {
	
	private List<Customer> customerList;

	@Override
	public Iterator<Customer> iterator() {
		return customerList.iterator();
	}

	@Override
	public List<Customer> getCustomerList() {
		return customerList;
	}

	@Override
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
	@Override
	public Customer get(int index) {
		return this.customerList.get(index);
	}
	
	@Override
	public int size() {
		return this.customerList.size();
	}
	
	@Override 
	public int indexOf(Customer customer) {
		return this.customerList.indexOf(customer);
	}
	
	@Override
	public void add(Customer customer) {
		this.customerList.add(customer);
	}
	
	@Override
	public void clear() {
		this.customerList.clear();
	}
	
	@Override
	public void remove(int index) {
		this.customerList.remove(index);
	}
	
	@Override
	@PostConstruct
	public void init() {
		customerList = new ArrayList<Customer>();
		Customer customer1 = new CustomerImpl();
		customer1.setId(1);
		customer1.setName("Heinz");
		customer1.setSurname("Wurst");
		customer1.setUsername("hwurst");
		customerList.add(customer1);
	}	
	
}
