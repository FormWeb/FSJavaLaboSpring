package com.example.projectbackend.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "resume")
    private String resume;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String title, String resume) {
        this.title = title;
        this.resume = resume;
    }

    public Book(String title, String resume, Author author) {
        this.title = title;
        this.resume = resume;
        this.author = author;
    }

    public Book(int id, String title, String resume, Author author) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", author=" + author +
                '}';
    }
}
