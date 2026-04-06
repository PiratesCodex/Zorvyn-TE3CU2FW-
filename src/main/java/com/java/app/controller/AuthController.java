package com.java.app.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.app.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import com.java.app.repository.UserRepository;
import com.java.app.security.JwtUtil;
import com.java.app.service.TokenBlacklistService;
import com.java.app.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserRepository repo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;
    private final TokenBlacklistService blacklistService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User db = repo.findByEmail(user.getEmail())
                .orElseThrow();

        if (!encoder.matches(user.getPassword(), db.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(db.getEmail(), db.getRole().name());
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            blacklistService.blacklist(token, jwtUtil.extractExpiry(token));
        }

        return "Logged out";
    }
}
