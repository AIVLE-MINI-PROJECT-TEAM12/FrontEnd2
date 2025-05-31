package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO.Response> findAll(String token);  // ✅ 수정
    Book findById(String token, Integer bookId);
    Book createBook(String token, BookDTO.Post bookDto);
    Book update(String token, Integer id, BookDTO.Put bookDto);
    Book update(String token, Integer id, BookDTO.Patch bookDto);
    void delete(String token, Integer id);
}
