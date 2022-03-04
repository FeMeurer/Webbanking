package de.telekom.sea7.inter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.telekom.sea7.impl.repository.Customer;
import de.telekom.sea7.impl.repository.Iban;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByUsername(String username);

}
