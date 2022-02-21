package de.telekom.sea7.impl.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Controller
public class TransactionListViewImpl {
	
	@Autowired
	TransactionList transactionList;
	
	@GetMapping("/")
	public String getHtml(Model model) {
		model.addAttribute("transactions", transactionList);
		return "index";
	}

}
