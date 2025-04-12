package com.rocketcode.backend_library.service;

import com.rocketcode.backend_library.mapper.LoanMapper;
import com.rocketcode.backend_library.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanMapper loanMapper;


    public List<Loan> getActiveLoans() {
        return loanMapper.getActiveLoans();
    }

    public Loan getLoanByBookId(int bookId) {
        return loanMapper.getLoanByBookId(bookId);
    }

    public void createLoan(Loan loan) {
        loanMapper.insertLoan(loan);
    }

    public void returnLoan(int id) {
        loanMapper.returnLoan(id);
    }
}
