package de.telekom.sea7.impl.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

@Controller
public class ViewImpl {
	
	@Autowired
	TransactionList transactionList;
	
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
			+				"<a href=\"index.html\">Webbanking</a>"
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
		String json = "{ \"transactions\" : [";
		for (Transaction transaction : transactionList) {
			json = json.concat("{");
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
			if (transactionList.indexOf(transaction) < transactionList.size() - 1) {
				json = json.concat(",");
			}
		}
		json = json.concat("]}");
		return json;
	}
	

}
