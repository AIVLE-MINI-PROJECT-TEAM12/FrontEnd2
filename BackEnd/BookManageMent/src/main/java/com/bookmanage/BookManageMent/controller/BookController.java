package com.bookmanage.BookManageMent.controller;

import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO.Response> getAllBooks(@RequestHeader("Authorization") String token) {
        return bookService.findAll(token);
    }

    @GetMapping("/{id}")
    public Book getBookById(@RequestHeader("Authorization") String token, @PathVariable Integer id) {
        return bookService.findById(token, id);
    }

    @GetMapping("/my")
    public List<BookDTO.Response> getMyBooks(@RequestHeader("Authorization") String token) {
        return bookService.findAll(token);
    }


    @PostMapping
    public Book createBook(@RequestHeader("Authorization") String token, @RequestBody BookDTO.Post bookDto) {
        return bookService.createBook(token, bookDto);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestHeader("Authorization") String token, @PathVariable Integer id, @RequestBody BookDTO.Put bookDto) {
        return bookService.update(token, id, bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@RequestHeader("Authorization") String token, @PathVariable Integer id) {
        bookService.delete(token, id);
    }

    @PatchMapping("/{id}/cover")
    public Book updateBookCover(@RequestHeader("Authorization") String token,
                                @PathVariable Integer id,
                                @RequestBody BookDTO.Patch bookDto) {
        System.out.println("✅ PATCH 요청 도착 book_image = " + bookDto.getBook_image());
        return bookService.update(token, id, bookDto);
    }

}
