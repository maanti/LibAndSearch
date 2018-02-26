package com.praktos.entity;

import javax.persistence.*;

@Entity
public class Sources {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private String year;
    private String type;
    private String link;
    private String tags;
    private String path;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Sources(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sources sources = (Sources) o;

        if (!id.equals(sources.id)) return false;
        if (name != null ? !name.equals(sources.name) : sources.name != null) return false;
        if (author != null ? !author.equals(sources.author) : sources.author != null) return false;
        if (publisher != null ? !publisher.equals(sources.publisher) : sources.publisher != null) return false;
        if (year != null ? !year.equals(sources.year) : sources.year != null) return false;
        if (type != null ? !type.equals(sources.type) : sources.type != null) return false;
        if (link != null ? !link.equals(sources.link) : sources.link != null) return false;
        if (tags != null ? !tags.equals(sources.tags) : sources.tags != null) return false;
        if (path != null ? !path.equals(sources.path) : sources.path != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

}
