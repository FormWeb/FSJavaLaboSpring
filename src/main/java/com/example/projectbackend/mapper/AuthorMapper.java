package com.example.projectbackend.mapper;

import com.example.projectbackend.model.dto.AuthorDTO;
import com.example.projectbackend.model.entity.Author;
import com.example.projectbackend.model.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorMapper {

    public AuthorDTO.BookDTO bookToDto(Book book) {
        return new AuthorDTO.BookDTO(
                book.getTitle(),
                book.getResume()
        );
    }

    // Transforme un objet Author en objet AuthorDTO
    public AuthorDTO toDto(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());

        if (author.getBooks() != null) {
            // .map permet d'appliquer une méthode sur
            // chaque élément d'une liste
            dto.setBooks(author.getBooks()
                    .stream()
                    .map(this::bookToDto)
                    .collect(Collectors.toList())
            );

//            Equivalent avec boucle :


//            List<AuthorDTO.BookDTO> bookDtoList = new ArrayList<>();
//
//            for (Book book : author.getBooks()) {
//                bookDtoList.add(bookToDto(book));
//            }
//
//            dto.setBooks(bookDtoList);

        }

        return dto;
    }

    // Transforme un DTO en entité
    public Author toEntity(AuthorDTO authorDTO) {
        if (authorDTO == null) {
            return null;
        }

        Author entity = new Author();
        entity.setId(authorDTO.getId());
        entity.setFirstName(authorDTO.getFirstName());
        entity.setLastName(authorDTO.getLastName());
        return entity;
    }
}
