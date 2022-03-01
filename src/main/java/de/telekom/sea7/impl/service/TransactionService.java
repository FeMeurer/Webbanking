package de.telekom.sea7.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea7.impl.repository.Transaction;
import de.telekom.sea7.inter.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;
	
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
			return null;
		}
	}
	
	public Transaction addTransaction(Transaction transaction) {
		transactionRepo.save(transaction);
		return null;
	}
	
	public Transaction deleteTransaction(long id) {
		transactionRepo.deleteById(id);
		return null;
	}

}
