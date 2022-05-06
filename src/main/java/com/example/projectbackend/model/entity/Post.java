package com.example.projectbackend.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    @CreationTimestamp
    private Instant date;

    public Post() {
    }

    public Post(int id, String message, Instant date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Post(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
