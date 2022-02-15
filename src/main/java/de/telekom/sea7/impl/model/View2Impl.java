package de.telekom.sea7.impl.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class View2Impl {
	
	@GetMapping("/showSomething.html")
	@ResponseBody
	public String getHtml() {
		return "Hallo";
	}
}