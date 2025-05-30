package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
    }


    @Override
    public Book create(BookDTO bookDto) {
        Book book = Book.builder()
                .book_name(bookDto.getBook_name())
                .summary(bookDto.getSummary())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, BookDTO bookDto) {
        Book book = findById(id);
        book.setBook_name(bookDto.getBook_name());
        book.setSummary(bookDto.getSummary());
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}


