package com.bookmanage.BookManageMent.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 50)
    private String book_name;

    @Column(nullable = false)
    private LocalDateTime create_date;

    private LocalDateTime modify_date;

    @Column(nullable = false, length = 500)
    private String summary;

    @Column(name = "book_image", columnDefinition = "TEXT")
    private String book_image;
}
