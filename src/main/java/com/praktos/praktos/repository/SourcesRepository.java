package com.praktos.praktos.repository;

import com.praktos.praktos.entity.Sources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SourcesRepository extends CrudRepository<Sources,Integer> {

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where lower(name) like concat('%', :name, '%') ")
    List<Sources> findSourcesByName(@Param("name") String name);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where lower(author) like concat('%', :author, '%') ")
    List<Sources> findSourcesByAuthor(@Param("author") String author);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where lower(publisher) like concat('%', :publisher, '%') ")
    List<Sources> findSourcesByPublisher(@Param("publisher") String publisher);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where lower(year) like concat('%', :year, '%') ")
    List<Sources> findSourcesByYear(@Param("year") String year);

    @Query(value = "select name, author, publisher, year, type, link, path, tags from Sources where lower(tags) like concat('%', :tags, '%') ")
    List<Sources> findSourcesByTags(@Param("tags") String tags);

    List<Sources> findAll();

    @Query("select distinct author from Sources ORDER BY author")
    List<Object> getAuthorsList();

    @Query("select distinct publisher from Sources ORDER BY publisher")
    List<Object> getPublishersList();

    @Query("select distinct year from Sources ORDER BY year")
    List<Object> getYearsList();
}