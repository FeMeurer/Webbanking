package de.telekom.sea7.impl.view;

import java.util.Iterator;
import java.util.List;

import de.telekom.sea7.inter.model.Customer;

public class CustomerListImpl implements Iterable<Customer> {
	
	private List<Customer> customerList;

	@Override
	public Iterator<Customer> iterator() {
		return customerList.iterator();
	}

}
