package com.springmvc.chap08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example02Controller {

	@GetMapping("/exam02")
	public String requestMethod(Model model) {		   	  
	   	return "webpage08_02";
	}
	
	@GetMapping("/manager/tag")
	public String requestMethod2(Model model) {		  	  
	   	return "webpage08_02";
	}	
	 
}
