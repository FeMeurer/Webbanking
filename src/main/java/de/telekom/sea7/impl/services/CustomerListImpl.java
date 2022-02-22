package de.telekom.sea7.impl.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import de.telekom.sea7.inter.model.Customer;

@Service
public class CustomerListImpl implements Iterable<Customer> {
	
	private List<Customer> customerList;

	@Override
	public Iterator<Customer> iterator() {
		return customerList.iterator();
	}

}
