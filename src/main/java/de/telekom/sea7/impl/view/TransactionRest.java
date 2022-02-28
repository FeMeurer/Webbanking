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

import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@RestController
public class TransactionRest {
	
	@Autowired
	TransactionList transactionList;
	
	@GetMapping("/transaction")
	public List<Transaction> getTransactionList() {
		return transactionList.getTransactionList();
	}
	
	@GetMapping("/transaction/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		return transactionList.get(id);
	}
	
	@PostMapping("/transaction")
	public Transaction addTransaction(@RequestBody de.telekom.sea7.inter.model.Transaction transaction) {
		transactionList.add(transaction);
		return null;
	}
	
	@PutMapping("/transaction/{id}")
	public Transaction updateTransaction(@PathVariable int id, @RequestBody de.telekom.sea7.inter.model.Transaction transaction) {
		Transaction oldTransaction = transactionList.get(id);
		oldTransaction.setID(transaction.getID());
		oldTransaction.setReceiver_ID(transaction.getReceiver_ID());
		oldTransaction.setIban_ID(transaction.getIban_ID());
		oldTransaction.setBic(transaction.getBic());
		oldTransaction.setAmount(transaction.getAmount());
		oldTransaction.setPurpose(transaction.getPurpose());
		oldTransaction.setCreationDate(LocalDateTime.now());
		return null;
	}
	
	@DeleteMapping("/transaction/{id}")
	public Transaction deleteTransaction(@PathVariable int id) {
		transactionList.remove(id);
		return null;
	}
	
}
