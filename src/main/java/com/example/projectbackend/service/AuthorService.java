package com.example.projectbackend.service;

import com.example.projectbackend.mapper.AuthorMapper;
import com.example.projectbackend.model.dto.AuthorDTO;
import com.example.projectbackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorDTO save(AuthorDTO authorDTO) {
        return authorMapper.toDto(
                authorRepository.save(authorMapper.toEntity(authorDTO))
        );
    }

    public Set<AuthorDTO> getAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toSet());
    }

    public AuthorDTO getAuthorById(int id) {
        return authorMapper.toDto(
                authorRepository.findById(id).orElse(null)
        );
    }

    public String deleteAuthor(int id) {
        authorRepository.deleteById(id);
        return "Author deleted";
    }
}
