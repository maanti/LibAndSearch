package com.praktos.praktos.repository;

import com.praktos.praktos.entity.Sources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SourcesRepository extends CrudRepository<Sources,Integer> {

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where author like concat('%', :author, '%') ")
    List<Sources> findSourcesByAuthor(@Param("author") String author);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where publisher like concat('%', :publisher, '%') ")
    List<Sources> findSourcesByPublisher(@Param("publisher") String publisher);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where year like concat('%', :year, '%') ")
    List<Sources> findSourcesByYear(@Param("year") String year);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where tags like concat('%', :tags, '%') ")
    List<Sources> findSourcesByTags(@Param("tags") String tags);

    List<Sources> findAll();

    @Query("select distinct author from Sources ORDER BY author")
    List<Object> getAuthorsList();

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where name like concat('%', :name, '%') ")
    List<Sources> findSourcesByName(@Param("name") String name);

}