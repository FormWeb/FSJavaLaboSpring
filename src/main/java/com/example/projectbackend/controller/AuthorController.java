package com.example.projectbackend.controller;

import com.example.projectbackend.model.dto.AuthorDTO;
import com.example.projectbackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Set<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }
}
