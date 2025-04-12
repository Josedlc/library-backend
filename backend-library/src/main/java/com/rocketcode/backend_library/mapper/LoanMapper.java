package com.rocketcode.backend_library.mapper;

import com.rocketcode.backend_library.model.Loan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LoanMapper {

    @Select("SELECT * FROM loans WHERE status = 'PRESTADO'")
    List<Loan> getActiveLoans();

    @Select("SELECT * FROM loans WHERE book_id = #{bookId} AND status = 'PRESTADO'")
    Loan getLoanByBookId(int bookId);

    @Insert("INSERT INTO loans (user_id, book_id, loan_date, return_date, status) VALUES (#{userId}, #{bookId}, #{loanDate}, #{returnDate}, #{status})")
    void insertLoan(Loan loan);

    @Update("UPDATE loans SET status = 'DEVUELTO' WHERE id = #{id}")
    void returnLoan(int id);
}
