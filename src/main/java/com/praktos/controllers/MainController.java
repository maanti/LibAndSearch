package com.praktos.controllers;

import com.praktos.entity.Sources;
import com.praktos.entity.Userr;
import com.praktos.repository.SourcesRepository;
import com.praktos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MainController {

    private final SourcesRepository sourcesRepository;

    private final UserRepository userRepository;

    @Autowired
    public MainController(SourcesRepository sourcesRepository, UserRepository userRepository) {
        this.sourcesRepository = sourcesRepository;
        this.userRepository = userRepository;
    }

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
                list.addAll(sourcesRepository.findSourcesByYear(Integer.parseInt(search_req)));
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
        return sourcesRepository.getAuthorsList();
    }

    @RequestMapping("/getCatalog")
    public @ResponseBody List<Sources> getCatalog(){
        return sourcesRepository.findAll();
    }

    @RequestMapping("/getUsers")
    public @ResponseBody List<Userr> getUsers(@RequestParam("username") String username,
                                              @RequestParam("password") String password){
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    @RequestMapping("/lol")
    public @ResponseBody List<Userr> getU(){
        return userRepository.findUserByUsernameAndPassword("aa", "aa");
    }


}