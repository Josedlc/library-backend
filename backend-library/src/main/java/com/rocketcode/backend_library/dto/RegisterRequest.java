package com.rocketcode.backend_library.dto;

import lombok.Data;


@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role;

}
