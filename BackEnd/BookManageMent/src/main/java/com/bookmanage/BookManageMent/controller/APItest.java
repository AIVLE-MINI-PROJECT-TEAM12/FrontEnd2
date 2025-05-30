package com.bookmanage.BookManageMent.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class APItest {

    @GetMapping("/api/hello")
    public String hello(){
        System.out.println(">>> /api/hello 호출됨");
        return "Hello from Spring Boot!";
    }
}
