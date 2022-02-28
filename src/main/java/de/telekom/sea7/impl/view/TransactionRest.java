package de.telekom.sea7.impl.view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.impl.repository.Transaction;
import de.telekom.sea7.inter.repository.TransactionRepository;

@RestController
public class TransactionRest {
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@GetMapping("/transaction")
	public List<Transaction> getTransactionList() {
		return transactionRepo.findAll();
	}
	
	@GetMapping("/transaction/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		Optional<Transaction> optionalTransaction = transactionRepo.findById(id);
		Transaction transaction = new Transaction();
		transaction = optionalTransaction.get();
		return transaction;
	}

	@PostMapping("/transaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		transactionRepo.save(transaction);
		return null;
	}

	@DeleteMapping("/transaction/{id}")
	public Transaction deleteTransaction(@PathVariable int id) {
		transactionRepo.deleteById(id);
		return null;
	}
	
}
