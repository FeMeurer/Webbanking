package de.telekom.sea7.impl.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.sea7.impl.repository.Bic;
import de.telekom.sea7.impl.repository.Customer;
import de.telekom.sea7.impl.repository.Iban;
import de.telekom.sea7.impl.repository.Transaction;
import de.telekom.sea7.inter.repository.BicRepository;
import de.telekom.sea7.inter.repository.CustomerRepository;
import de.telekom.sea7.inter.repository.IbanRepository;
import de.telekom.sea7.inter.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	IbanRepository ibanRepo;
	
	@Autowired
	BicRepository bicRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	public List<Transaction> getTransactionList(long userid) {
		Optional<Customer> optionalCustomer = customerRepo.findById(userid);
		
		System.out.println(optionalCustomer.isPresent());
		if (optionalCustomer.isPresent()) {
			Customer customer = new Customer();
			customer = optionalCustomer.get();
			System.out.println(customer.getName());
			return customer.getTransactions();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kunde wurde nicht gefunden");
		}
	}
	
	public Transaction getTransaction(long id) {
		Optional<Transaction> optionalTransaction = transactionRepo.findById(id);
		
		if (optionalTransaction.isPresent()) {
			Transaction transaction = new Transaction();
			transaction = optionalTransaction.get();
			return transaction;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zahlung wurde nicht gefunden");
		}
	}
	
	public Transaction addTransaction(Transaction transaction) {
		transaction.setCreationdate(LocalDateTime.now());
		
		Bic newBic = transaction.getIban().getBic();
		List<Bic> bicList = bicRepo.findByBic(newBic.getBic());
		for (Bic bic : bicList) {
			if (bic.equals(newBic)) {
				transaction.getIban().setBic(bic);
			}
		}
		
		Iban newIban = transaction.getIban();
		List<Iban> ibanList = ibanRepo.findByIban(newIban.getIban());
		for (Iban iban : ibanList) {
			if (iban.equals(newIban)) {
				transaction.setIban(iban);
			}
		}
		
		transactionRepo.save(transaction);
		
		return null;	
	}
	
	public Transaction deleteTransaction(long id) {
		transactionRepo.deleteById(id);
		return null;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("#### Transaction service initialized! ####");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("#### Transaction service closed! ####");
	}

}
