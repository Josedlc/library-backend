package com.rocketcode.backend_library.dto;

import lombok.Data;

@Data
public class UserResponse {
    Long id;
    String nombre;
    String email;
    String role;

    public UserResponse(Long id, String name, String email, String role) {
    }
}
