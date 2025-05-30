package com.bookmanage.BookManageMent.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.ErrorResponse;

import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false, length = 50)
    private String book_name;

    @Column(nullable = false)
    private LocalDateTime create_date;

    private LocalDateTime modify_date;

    @Column(nullable = false, length = 500)
    private String summary;

    @Column(name = "user_name")
    private String user_name;


    private String book_image;

}
