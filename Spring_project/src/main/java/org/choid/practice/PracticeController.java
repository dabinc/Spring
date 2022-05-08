package org.choid.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {

	@Autowired
	private PracticeService practiceService;
	
	@GetMapping(value="/practice")
	public String practiceTest(Model model) {
		model.addAttribute("message", practiceService.practice("sample input")); 
		return "hello";
	}
}
