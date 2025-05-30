package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book create(BookDTO bookDto);
    Book update(Long id, BookDTO bookDTO);
    void delete(Long id);

}