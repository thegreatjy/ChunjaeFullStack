package com.springmvc.chap16;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webpage16_01")
public class Example01Controller {	

	@GetMapping
	public String showForm() {	
		return "webpage16_01";
	}	
		
}
