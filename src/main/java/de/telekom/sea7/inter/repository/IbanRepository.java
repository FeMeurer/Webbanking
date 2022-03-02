package de.telekom.sea7.inter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.telekom.sea7.impl.repository.Bic;
import de.telekom.sea7.impl.repository.Iban;

public interface IbanRepository extends JpaRepository<Iban, Long> {
	
	List<Iban> findByIban(String iban);
	
}
