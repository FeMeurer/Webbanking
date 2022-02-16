package de.telekom.sea7.impl.model;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Controller
public class ViewImpl {
	
	@Autowired
	TransactionList transactionList;
	@Autowired
	Transaction transaction;
	@Autowired
	Transaction transaction2;
//	@Autowired
//	Transaction transaction3;
	
	@GetMapping("/index.html")
	@ResponseBody
	public String getHtml() {
		
		return 
				"<!DOCTYPE html>"
			+	"<html>"
			+		"<head>"
			+			"<meta charset=\"UTF-8\">"
			+			"<title>Webbanking</title>"
			+			"<link href=\"/style/default.css\" rel=\"stylesheet\">"
			+			"<script src=\"/script/index.js\" type=\"module\"></script>"
			+		"</head>"
			+		"<body>"
			+			"<header>"
			+				"<a href=\"showSomething.html\">Webbanking</a>"
			+			"</header>"
			+			"<main>"
			+				"<div id=\"headline\">"
			+					"Zahlungen"
			+				"</div>"
			+				"<div id=\"flex-container\">"
			+				"</div>"
			+			"</main>"
			+		"</body>"
			+	"</html>";
	}
	
	@GetMapping("/data/transactions.json")
	@ResponseBody
	public String getJson() {
		this.transaction.setAmount(50.00f);
		this.transaction.setReceiver("Rüdiger");
		this.transaction.setIban("DE9191");
		this.transaction.setBic("BANK01");
		this.transaction.setPurpose("Geld");
		this.transaction.setDate(LocalDateTime.now());
		//transactionList.add(transaction1);
		
		this.transaction2.setAmount(20.00f);
		this.transaction2.setReceiver("Hans");
		this.transaction2.setIban("DE9191");
		this.transaction2.setBic("BANK01");
		this.transaction2.setPurpose("Geld");
		this.transaction2.setDate(LocalDateTime.now());
//		transactionList.add(transaction2);
//		
//		this.transaction3.setAmount(10.00f);
//		this.transaction3.setReceiver("Lars");
//		this.transaction3.setIban("DE9191");
//		this.transaction3.setBic("BANK01");
//		this.transaction3.setPurpose("Geld");
//		this.transaction3.setDate(LocalDateTime.now());
//		transactionList.add(transaction3);
		
		String json = "{ \"transactions\" : [";
		json = json.concat("{");
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
		json = json.concat(",");
		json = json.concat("{");
		json = json.concat("\"receiver\" : \"");
		json = json.concat(transaction2.getReceiver());
		json = json.concat("\",");
	    json = json.concat("\"iban\" : \"");
		json = json.concat(transaction2.getIban());
		json = json.concat("\",");
		json = json.concat("\"bic\" : \"");
		json = json.concat(transaction2.getBic() );
		json = json.concat("\",");
		json = json.concat("\"purpose\" : \"");
		json = json.concat(transaction2.getPurpose() );
		json = json.concat("\",");
		json = json.concat("\"amount\" : " );
		json = json.concat(Float.toString(transaction2.getAmount()));
		json = json.concat("}");
		json = json.concat("]}");
		return json;
	}
}
