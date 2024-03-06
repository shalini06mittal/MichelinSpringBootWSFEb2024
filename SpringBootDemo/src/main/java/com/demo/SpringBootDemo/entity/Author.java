package com.demo.SpringBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;
// hibernate managed entity
@Entity
public class Author {


    @Id
    private int aid;
    private String name;
    @OneToMany(mappedBy = "author")
    Set<Book> books;

    public Author() {
    }

    public Author(int aid, String name, Set<Book> books) {
        this.aid = aid;
        this.name = name;
        this.books = books;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                '}';
    }
}
