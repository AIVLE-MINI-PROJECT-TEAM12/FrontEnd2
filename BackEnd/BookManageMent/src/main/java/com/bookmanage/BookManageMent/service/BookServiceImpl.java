package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.domain.User;
import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.repository.BookRepository;
import com.bookmanage.BookManageMent.repository.UserRepository;
import com.bookmanage.BookManageMent.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private User getUserFromToken(String token) {
        String userId = jwtUtil.validateAndGetUserId(token.replace("Bearer ", ""));
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }

    @Override
    public List<BookDTO.Response> findAll(String token) {
        getUserFromToken(token); // 인증만 통과
        return bookRepository.findAll().stream()
                .map(book -> new BookDTO.Response(
                        book.getUser().getUser_id(),
                        book.getUser().getUser_name(),
                        book.getBook_id(),
                        book.getBook_name(),
                        book.getCreate_date(),
                        book.getModify_date(),
                        book.getSummary(),
                        book.getBook_image()
                ))
                .toList();
    }

    @Override
    public Book findById(String token, Integer book_id) {
        getUserFromToken(token); // 인증만 확인
        return bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
    }

    @Override
    public Book createBook(String token, BookDTO.Post bookDto) {
        User user = getUserFromToken(token);
        Book book = Book.builder()
                .user(user)
                .book_name(bookDto.getBook_name())
                .summary(bookDto.getSummary())
                .book_image(bookDto.getBook_image())
                .create_date(LocalDateTime.now())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public Book update(String token, Integer id, BookDTO.Put bookDto) {
        getUserFromToken(token);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
        book.setBook_name(bookDto.getBook_name());
        book.setSummary(bookDto.getSummary());
        book.setBook_image(bookDto.getBook_image());
        book.setModify_date(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public Book update(String token, Integer id, BookDTO.Patch bookDto) {
        getUserFromToken(token);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
        book.setBook_image(bookDto.getBook_image());
        book.setModify_date(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void delete(String token, Integer id) {
        getUserFromToken(token);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
        bookRepository.delete(book);
    }
}
