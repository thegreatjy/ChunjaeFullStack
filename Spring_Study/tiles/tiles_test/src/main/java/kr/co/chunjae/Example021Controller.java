package kr.co.chunjae;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webpage16_02")
public class Example021Controller {

	@GetMapping
	public String showForm() {	
		return "webpage16_02";
	}	
		
}
