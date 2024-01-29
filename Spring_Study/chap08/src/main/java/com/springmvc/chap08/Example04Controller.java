package com.springmvc.chap08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Example04Controller {

	@GetMapping("/login")
	public String requestMethod(Model model) {		   	  
	   	return "loginform";
	}
	
	@GetMapping("/admin")
	public String requestMethod2(Model model) {		  	  
	   	return  "webpage08_04";
	}	
	
	@GetMapping("/logout")
	public String logout(Model model) { 
		return "loginform";  
	}


}
