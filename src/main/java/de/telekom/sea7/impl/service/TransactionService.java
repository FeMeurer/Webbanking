package de.telekom.sea7.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.telekom.sea7.impl.repository.Transaction;
import de.telekom.sea7.inter.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;
	
	public List<Transaction> getTransactionList() {
		return transactionRepo.findAll();
	}
	
	public Transaction getTransaction(int id) {
		Optional<Transaction> optionalTransaction = transactionRepo.findById(id);
		Transaction transaction = new Transaction();
		transaction = optionalTransaction.get();
		return transaction;
	}
	
	public Transaction addTransaction(Transaction transaction) {
		transactionRepo.save(transaction);
		return null;
	}
	
	public Transaction deleteTransaction(int id) {
		transactionRepo.deleteById(id);
		return null;
	}

}
