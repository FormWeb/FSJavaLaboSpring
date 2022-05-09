package com.example.projectbackend.model.dto;

import java.util.List;

public class AuthorDTO {
    private int id;

    private String firstName;

    private String lastName;

    private List<AuthorDTO.BookDTO> books;

    public static class BookDTO {
        private String title;
        private String resume;

        public BookDTO() {
        }

        public BookDTO(String title, String resume) {
            this.title = title;
            this.resume = resume;
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
    }

    public AuthorDTO() {
    }

    public AuthorDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
