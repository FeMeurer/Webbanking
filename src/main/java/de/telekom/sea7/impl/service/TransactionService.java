package de.telekom.sea7.impl.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.sea7.impl.repository.Bic;
import de.telekom.sea7.impl.repository.Iban;
import de.telekom.sea7.impl.repository.Transaction;
import de.telekom.sea7.inter.repository.BicRepository;
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
	
	public List<Transaction> getTransactionList() {
		return transactionRepo.findAll();
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
		transactionRepo.save(transaction);
		return null;
	}
	
	public Transaction deleteTransaction(long id) {
		transactionRepo.deleteById(id);
		return null;
	}

}
