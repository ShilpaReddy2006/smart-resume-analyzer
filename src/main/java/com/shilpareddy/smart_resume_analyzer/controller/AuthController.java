package com.shilpareddy.smart_resume_analyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.shilpareddy.smart_resume_analyzer.model.User;
import com.shilpareddy.smart_resume_analyzer.repository.UserRepository;
import com.shilpareddy.smart_resume_analyzer.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userRepository.findByEmail(user.getEmail());

        if (dbUser != null &&
            passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {

            return JwtUtil.generateToken(user.getEmail());
        }

        return "Invalid credentials";
    }
}




