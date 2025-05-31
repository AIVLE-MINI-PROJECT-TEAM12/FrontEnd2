package com.bookmanage.BookManageMent.dto;

import lombok.*;

public class UserDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post {
        private String user_id;
        private String user_name;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @Builder
    public static class Response {
        private String user_id;
        private String user_name;
    }


}
