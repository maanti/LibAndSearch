package com.praktos.praktos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
