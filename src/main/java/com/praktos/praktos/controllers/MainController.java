package com.praktos.praktos.controllers;

import com.praktos.praktos.entity.Sources;
import com.praktos.praktos.repository.SourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private SourcesRepository sourcesRepository;

    @RequestMapping(value = "/findBook", method = RequestMethod.POST)
    public @ResponseBody
    List<Sources> findBook(@RequestParam("name") String name)
    {

        List<Sources> list = new ArrayList<>();
        list.addAll(sourcesRepository.findSourcesByName(name));
        System.out.println(name);
        System.out.println(list.size());
        return list;

    }
}
