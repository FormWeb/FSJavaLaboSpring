package com.example.projectbackend.mapper;

import com.example.projectbackend.model.dto.AuthorDTO;
import com.example.projectbackend.model.dto.BookDTO;
import com.example.projectbackend.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    @Autowired
    private AuthorMapper authorMapper;

    public BookDTO toDto(Book book) {
        if (book == null) {
            return null;
        }

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setResume(book.getResume());
        dto.setAuthor(authorMapper.toDto(book.getAuthor()));

        return dto;

    }

    public Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }

        Book entity = new Book();
        entity.setId(bookDTO.getId());
        entity.setTitle(bookDTO.getTitle());
        entity.setResume(bookDTO.getResume());
        entity.setAuthor(authorMapper.toEntity(bookDTO.getAuthor()));

        return entity;
    }
}
