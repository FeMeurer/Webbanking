package de.telekom.sea7.impl.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewImpl {
	
	@Autowired
	Transaction transaction;
	
	@GetMapping("/index1.html")
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
		String json = "{"
					+ "\"receiver\" : \"" + transaction.getReceiver() + "\","
					+ "\"iban\" : \"" + transaction.getIban() + "\","
					+ "\"bic\" : \"" + transaction.getBic() + "\","
					+ "\"purpose\" : \"" + transaction.getPurpose() + "\","
					+ "\"amount\" : " + transaction.getAmount()
					+ "}";
		return json;
	}
}
