package com.rocketcode.backend_library.controller;

import com.rocketcode.backend_library.dto.LoginRequest;
import com.rocketcode.backend_library.dto.RegisterRequest;
import com.rocketcode.backend_library.dto.UserResponse;
import com.rocketcode.backend_library.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> registrar(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }
}
