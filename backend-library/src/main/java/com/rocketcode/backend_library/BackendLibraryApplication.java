package com.rocketcode.backend_library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rocketcode.backend_library.mapper")
public class BackendLibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendLibraryApplication.class, args);
    }
}
