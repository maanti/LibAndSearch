package com.praktos.praktos.repository;

import com.praktos.praktos.entity.Sources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Objects;

public interface SourcesRepository extends CrudRepository<Sources,Integer> {

    List<Sources> findSourcesByAuthor(String author);
    List<Sources> findSourcesByName(String name);
    List<Sources> findSourcesByPublisher(String publisher);
    List<Sources> findSourcesByYear(Integer year);
    List<Sources> findSourcesByTags(String tags);

    @Query("select distinct author from Sources ORDER BY author")
    List<Object> getAuthorsList();

}
