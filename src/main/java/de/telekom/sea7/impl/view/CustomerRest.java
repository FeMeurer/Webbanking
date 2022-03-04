package de.telekom.sea7.impl.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.impl.repository.Customer;
import de.telekom.sea7.impl.service.CustomerService;

@RestController
public class CustomerRest {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer/{username}")
	public Customer getCustomerById(@PathVariable String username) {
		return customerService.getCustomerByUsername(username);
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
}
