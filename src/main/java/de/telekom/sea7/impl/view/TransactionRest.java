package de.telekom.sea7.impl.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.impl.repository.Transaction;
import de.telekom.sea7.impl.service.TransactionService;

@RestController
public class TransactionRest {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transaction")
	public List<Transaction> getTransactionList() {
		return transactionService.getTransactionList();
	}
	
	@GetMapping("/transaction/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		return transactionService.getTransaction(id);
	}

	@PostMapping("/transaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

	@DeleteMapping("/transaction/{id}")
	public Transaction deleteTransaction(@PathVariable int id) {
		return transactionService.deleteTransaction(id);
	}
	
}
