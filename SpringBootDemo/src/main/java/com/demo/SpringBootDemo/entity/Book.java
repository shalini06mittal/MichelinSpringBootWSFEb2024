package com.demo.SpringBootDemo.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int bookid;
    private String title;
    private int year;

    @ManyToOne
    @JoinColumn(name="authorid")
    Author author;

// getters and setters
    // constructor


    public Book() {
    }

    public Book(int bookid, String title, int year, Author author) {
        this.bookid = bookid;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", title=" + title + ", year=" + year + "]";
    }
}

