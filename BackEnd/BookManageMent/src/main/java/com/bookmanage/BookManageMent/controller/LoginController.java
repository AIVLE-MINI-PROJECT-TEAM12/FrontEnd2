package com.bookmanage.BookManageMent.controller;

import com.bookmanage.BookManageMent.domain.User;
import com.bookmanage.BookManageMent.dto.UserDTO;
import com.bookmanage.BookManageMent.repository.UserRepository;
import com.bookmanage.BookManageMent.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO.Post request) {
        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        if (!user.getUser_name().equals(request.getUser_name())) {
            return ResponseEntity.status(401).body("이름 불일치");
        }

        String token = jwtUtil.generateToken(user.getUser_id());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
