package com.bookmanage.BookManageMent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long book_id;
    private String book_name;
    private String summary;
    private LocalDateTime create_date;
    private String book_image;
    private Integer user_id;
    private String user_name; // ✅ 이거 추가

}

