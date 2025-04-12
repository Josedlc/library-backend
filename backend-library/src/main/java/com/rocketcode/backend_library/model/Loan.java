package com.rocketcode.backend_library.model;

import lombok.Data;

import java.util.Date;

@Data
public class Loan {
    private int id;
    private int userId;
    private int bookId;
    private Date loanDate;
    private Date returnDate;
    private String status;
}
