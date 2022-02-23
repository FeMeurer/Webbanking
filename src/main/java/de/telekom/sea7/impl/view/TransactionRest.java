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

import de.telekom.sea7.impl.model.TransactionImpl;
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
	public void addTransaction(@RequestBody TransactionImpl transaction) {
		transactionList.add(transaction);
	}
	
	@PutMapping("/transaction/{id}")
	public Transaction updateTransaction(@PathVariable int id, @RequestBody TransactionImpl transaction) {
		Transaction oldTransaction = transactionList.get(id);
		oldTransaction.setId(transaction.getId());
		oldTransaction.setReceiver(transaction.getReceiver());
		oldTransaction.setIban(transaction.getIban());
		oldTransaction.setBic(transaction.getBic());
		oldTransaction.setAmount(transaction.getAmount());
		oldTransaction.setPurpose(transaction.getPurpose());
		oldTransaction.setDate(LocalDateTime.now());
		return null;
	}
	
	@DeleteMapping("/transaction/{id}")
	public Transaction deleteTransaction(@PathVariable int id) {
		transactionList.remove(id);
		return null;
	}
	
}
