package com.bookmanage.BookManageMent.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @Column(nullable = false, length = 50)
    private String user_id;

    @Column(nullable = false, length = 50)
    private String user_name;
}
