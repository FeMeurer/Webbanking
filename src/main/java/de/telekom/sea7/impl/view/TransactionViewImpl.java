package de.telekom.sea7.impl.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.impl.model.TransactionImpl;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Controller
public class TransactionViewImpl {
	
	@Autowired
	TransactionList transactionList;
	
	@GetMapping("/transaction")
	public String getTransactionHtml(@RequestParam int transaction, Model model) {
		model.addAttribute("transaction", transactionList.get(transaction - 1));
		return "transaction";
	}
	
	@GetMapping("/newTransaction")
	public String getNewTransaction(Model model) {
		model.addAttribute("transaction", new TransactionImpl());
		return "newTransaction";
	}
	
	@PostMapping("/newTransaction")
	public String newTransaction(@ModelAttribute("transaction") TransactionImpl transaction) {
		transactionList.add(transaction);
		return "redirect:/";
	}
	
}
