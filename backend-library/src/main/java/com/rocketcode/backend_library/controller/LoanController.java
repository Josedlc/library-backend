package com.rocketcode.backend_library.controller;

import com.rocketcode.backend_library.model.Loan;
import com.rocketcode.backend_library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;


    @GetMapping("/getActiveloans")
    public List<Loan> getActiveLoans() {
        return loanService.getActiveLoans();
    }


    @PostMapping("/create")
    public void createLoan(@RequestBody Loan loan) {
        loanService.createLoan(loan);
    }


    @PutMapping("/return/{id}")
    public void returnLoan(@PathVariable int id) {
        loanService.returnLoan(id);
    }
}
