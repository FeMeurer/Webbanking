package de.telekom.sea7.impl.model;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewImpl {
	
	@GetMapping("/index1.html")
	@ResponseBody
	public String getHtml() {
		
		return 
				"<!DOCTYPE html>"
			+	"<html>"
			+		"<head>"
			+			"<meta charset=\"UTF-8\">"
			+			"<title>Webbanking</title>"
			+			"<link href=\"/style/default1.css\" rel=\"stylesheet\">"
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
	
	@GetMapping("/style/default1.css")
	@ResponseBody
	public String getCSS() {
		
		return "header {background-color: red; overflow: hidden; width: 100%; position: fixed; box-shadow: 2px 0px 5px 5px rgba(0, 0, 0, 0.5); z-index: 1;}";
	}
}
