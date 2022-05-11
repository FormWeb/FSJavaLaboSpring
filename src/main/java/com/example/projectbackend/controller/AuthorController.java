package com.example.projectbackend.controller;

import com.example.projectbackend.model.dto.AuthorDTO;
import com.example.projectbackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public AuthorDTO getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public AuthorDTO addAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorDTO);
    }

    @DeleteMapping
    public String deleteAuthor(@RequestParam int id) {
        return authorService.deleteAuthor(id);
    }

    @PutMapping
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.updateAuthor(authorDTO);
    }
}
