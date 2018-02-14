package com.praktos.praktos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NavigationController {

    @RequestMapping(value = "/")
    public ModelAndView findBook() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/index");
        return model;
    }

    @RequestMapping(value = "/kek")
    public ModelAndView getAuthorsList() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/authors");
        return model;
    }

    @RequestMapping(value = "/authors")
    public ModelAndView getAuthors() {
        ModelAndView model = new ModelAndView();

        model.setViewName("../static/authors");
        return model;
    }

    @RequestMapping(value = "/publishers")
    public ModelAndView getPublishers() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/publishers");
        return model;
    }

    @RequestMapping(value = "/themes")
    public ModelAndView getThemes() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        return model;
    }

    @RequestMapping(value = "/years")
    public ModelAndView getYears() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/years");
        return model;
    }

    @RequestMapping(value = "/catalog")
    public ModelAndView getCatalog() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/catalog");
        return model;
    }
}
