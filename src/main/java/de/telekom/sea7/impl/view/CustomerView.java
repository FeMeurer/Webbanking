package de.telekom.sea7.impl.view;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.impl.model.Customer;


@RestController
public class CustomerView {
	
//	@Autowired
//	CustomerList customerList;

	@GetMapping("/customer")
	public List<Customer> getCustomer() {
//		return customerList.getCustomerList();
		return null;
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return null;
	}
	
	@GetMapping("/customer/{username}")
	public Customer getCustomerByUsername(@PathVariable String username) {
		return null;
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
//		customerList.add(customer);
		return null;
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
//		Customer oldCustomer = customerList.get(id);
//		oldCustomer.setId(customer.getId());
//		oldCustomer.setName(customer.getName());
//		oldCustomer.setSurname(customer.getSurname());
//		oldCustomer.setUsername(customer.getUsername());
		return null;
	}
	
	@DeleteMapping("/customer/{id}")
	public Customer deleteCustomer(@PathVariable int id) {
//		customerList.remove(id);
		return null;
	}
	
	
}
