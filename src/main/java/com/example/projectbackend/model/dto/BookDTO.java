package com.example.projectbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDTO {
    private int id;

    private String title;

    private String resume;

    @JsonIgnore
    private AuthorDTO author;

    private String authorName;

    public BookDTO() {
    }

    public BookDTO(int id, String title, String resume, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.author = author;
    }

    public BookDTO(String title, String resume, AuthorDTO author) {
        this.title = title;
        this.resume = resume;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public String getAuthorName() {
        return author.getFirstName() + " " + author.getLastName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
