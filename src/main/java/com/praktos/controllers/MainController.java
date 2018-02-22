package com.praktos.controllers;

import com.praktos.entity.Sources;
import com.praktos.repository.SourcesRepository;
import com.praktos.tikoLuceneSearch.Searcher;
import com.praktos.tikoLuceneSearch.index.DocumentIndexer;
import com.praktos.tikoLuceneSearch.index.FileToLuceneDocument;
import org.apache.lucene.document.Document;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private SourcesRepository sourcesRepository;
    private Searcher search;
    public MainController(){
    }

    @RequestMapping(value = "/findBook", method = RequestMethod.POST)
    public @ResponseBody
    List<Sources> findBook(@RequestParam("search_req") String search_req,
                           @RequestParam("filter") String filter) throws IOException, TikaException, SAXException {
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
            case ("file"): {
                List<Sources> sources = sourcesRepository.findSourcesById(2);
                List<Document> documents = new ArrayList<>();
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(3);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(4);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(5);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(6);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(8);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(10);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(11);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(13);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                sources = sourcesRepository.findSourcesById(14);
                documents.add(FileToLuceneDocument.createWith(sources.get(0)));
                DocumentIndexer indexer = new DocumentIndexer();
                indexer.index(false, documents);
                try {
                    search = new Searcher(indexer.readIndex());
                    list.addAll(search.fuzzySearch(search_req));
                    break;
                } catch (IOException e) {
                    System.err.println("IOException in MainController: ");
                    e.printStackTrace();
                    break;
                }
            }
        }

        return list;
    }

    @RequestMapping("/getAuthorsList")
    public @ResponseBody List<Object> getAuthorsList(){
        return sourcesRepository.getAuthorsList();
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
        return sourcesRepository.findAll();
    }


}