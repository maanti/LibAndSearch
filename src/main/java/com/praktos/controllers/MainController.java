package com.praktos.controllers;

import com.praktos.entity.Sources;
import com.praktos.repository.SourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private SourcesRepository sourcesRepository;

    @RequestMapping(value = "/findBook", method = RequestMethod.POST)
    public @ResponseBody
    List<Sources> findBook(@RequestParam("search_req") String search_req,
                           @RequestParam("filter") String filter)
    {
    List<Sources> list = new ArrayList<>();


        switch(filter){
            case ("name"): {
               list.addAll(sourcesRepository.findSourcesByName(search_req));
                break;
            }
            case ("author"): {
                list.addAll(sourcesRepository.findSourcesByAuthor(search_req));
                break;
            }
            case ("publisher"): {
                list.addAll(sourcesRepository.findSourcesByPublisher(search_req));
                break;
            }
            case ("year"): {
                list.addAll(sourcesRepository.findSourcesByYear(search_req));
                break;
            }
            case ("tags"): {
                list.addAll(sourcesRepository.findSourcesByTags(search_req));
                break;
            }
        }

        return list;
    }

    @RequestMapping("/getAuthorsList")
    public @ResponseBody List<Object> getAuthorsList(){
        List<Object> authors = sourcesRepository.getAuthorsList();
        return authors;
    }

    @RequestMapping("/getPublishersList")
    public @ResponseBody List<Object> getPublishersList(){
        List<Object> publishers = sourcesRepository.getPublishersList();
        return publishers;
    }

    @RequestMapping("/getYearsList")
    public @ResponseBody List<Object> getYearsList(){
        List<Object> years = sourcesRepository.getYearsList();
        return years;
    }

    @RequestMapping("/getCatalog")
    public @ResponseBody List<Sources> getCatalog(){
        List<Sources> sources = sourcesRepository.findAll();
        return sources;
    }

}