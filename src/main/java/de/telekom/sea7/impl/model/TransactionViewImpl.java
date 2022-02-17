package de.telekom.sea7.impl.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Controller
public class TransactionViewImpl {
	
	@Autowired
	TransactionList transactionList;
	
	@GetMapping("/transaction.html")
	@ResponseBody
	public String getTransactionHtml(@RequestParam int transaction) {
		
		return 
				"<!DOCTYPE html>"
			+	"<html>"
			+		"<head>"
			+			"<meta charset=\"UTF-8\">"
			+			"<title>Webbanking</title>"
			+			"<link href=\"/style/default.css\" rel=\"stylesheet\">"
			+			"<link href=\"/style/transaction.css\" rel=\"stylesheet\">"
			+			"<script src=\"/script/transaction.js\" type=\"module\"></script>"
			+		"</head>"
			+		"<body>"
			+			"<header>"
			+				"<a href=\"index.html\">Webbanking</a>"
			+			"</header>"
			+			"<main>"
			+				"<div id=\"headline\">"
			+					"Zahlung: " + transaction
			+				"</div>"
			+				"<div id=\"transaction\">"
			+				"</div>"
			+			"</main>"
			+		"</body>"
			+	"</html>";
	}
	
	@GetMapping("data/{id}/oneTransaction.json")
	@ResponseBody
	public String getTransaction(@PathVariable int id) {
		Transaction transaction = transactionList.get(id - 1);
		String json = "{";
		json = json.concat("\"id\" : ");
		json = json.concat(Integer.toString(transaction.getId()));
		json = json.concat(",");
		json = json.concat("\"receiver\" : \"");
		json = json.concat(transaction.getReceiver());
		json = json.concat("\",");
	    json = json.concat("\"iban\" : \"");
		json = json.concat(transaction.getIban());
		json = json.concat("\",");
		json = json.concat("\"bic\" : \"");
		json = json.concat(transaction.getBic() );
		json = json.concat("\",");
		json = json.concat("\"purpose\" : \"");
		json = json.concat(transaction.getPurpose() );
		json = json.concat("\",");
		json = json.concat("\"amount\" : " );
		json = json.concat(Float.toString(transaction.getAmount()));
		json = json.concat("}");
		
		return json;
	}

}
