package com.praktos.praktos.repository;

import com.praktos.praktos.entity.Sources;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SourcesRepository extends CrudRepository<Sources,Integer> {
    List<Sources> findSourcesByAuthor(String author);
    List<Sources> findSourcesByName(String name);
    List<Sources> findSourcesByPublisher(String publisher);
    List<Sources> findSourcesByYear(Integer year);
    List<Sources> findSourcesByTags(String tags);
}
