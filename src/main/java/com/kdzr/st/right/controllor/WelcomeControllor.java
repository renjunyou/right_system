package com.kdzr.st.right.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WelcomeControllor {
	
	@RequestMapping("/")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping("/head")
	public String head() {
		
		return "head";
	}
	
	@RequestMapping("/left")
	public String left() {
		
		return "left";
	}
	
	@RequestMapping("/body")
	public String body() {
		
		return "body";
	}

}
