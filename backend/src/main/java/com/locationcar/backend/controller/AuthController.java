package com.locationcar.backend.controller;


import com.locationcar.backend.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if ("admin".equals(request.username) && "password".equals(request.password)) {
            String token = jwtUtil.generateToken(request.username);
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    static class AuthRequest {
        public String username;
        public String password;

        // Add these getter methods
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    static class AuthResponse {
        public String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        // Optional: Add getter for token
        public String getToken() {
            return token;
        }
    }
}