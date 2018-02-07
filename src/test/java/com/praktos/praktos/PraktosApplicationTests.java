package com.praktos.praktos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PraktosApplicationTests {

	@GetMapping("/")
	public ModelAndView contextLoads() {
		return new ModelAndView("index");
	}

}
