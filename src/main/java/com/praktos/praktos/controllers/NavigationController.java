package com.praktos.praktos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

    @RequestMapping(value = "/find")
    public ModelAndView findBook() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/index");
        return model;
    }
}
