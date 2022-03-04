package de.telekom.sea7.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.sea7.impl.repository.Customer;
import de.telekom.sea7.inter.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	public Customer getCustomerByUsername(String username) {
		List<Customer> customerList = customerRepo.findByUsername(username);
		
		if (!customerList.isEmpty()) {
			return customerList.get(0);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kunde wurde nicht gefunden");
		}
	}
}
