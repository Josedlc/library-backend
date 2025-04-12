package com.rocketcode.backend_library.model;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;
}
