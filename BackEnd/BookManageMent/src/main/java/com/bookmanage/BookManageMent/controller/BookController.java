package com.bookmanage.BookManageMent.controller;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Vite 프론트 허용
public class BookController {

    private final BookRepository bookRepository;

    // ✅ 1. 전체 도서 조회
    @GetMapping
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            BookDTO dto = new BookDTO();
            dto.setBook_id(book.getBook_id());
            dto.setBook_name(book.getBook_name());
            dto.setSummary(book.getSummary());
            dto.setCreate_date(book.getCreate_date());
            dto.setBook_image(book.getBook_image());
            dto.setUser_id(book.getUser_id());
            dto.setUser_name(book.getUser_name()); // ✅ 하드코딩 제거

            return dto;
        }).collect(Collectors.toList());
    }

    // ✅ 2. 도서 상세 조회
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    // ✅ 3. 도서 등록
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setCreate_date(LocalDateTime.now());
        book.setModify_date(LocalDateTime.now());
        return bookRepository.save(book);
    }

    // ✅ 4. 도서 수정
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setBook_name(updatedBook.getBook_name());
        book.setSummary(updatedBook.getSummary());
        book.setUser_id(updatedBook.getUser_id());
        book.setUser_name(updatedBook.getUser_name()); // ✅ 수정 시 이름 반영
        book.setModify_date(LocalDateTime.now());

        return bookRepository.save(book);
    }

    // ✅ 5. 도서 삭제
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    // ✅ 6. 표지 이미지 생성
    @PostMapping("/{id}/cover")
    public Book generateCover(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setBook_image("https://via.placeholder.com/200x300?text=" + book.getBook_name());
        return bookRepository.save(book);
    }
}
