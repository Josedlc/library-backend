package com.rocketcode.backend_library.controller;

import com.rocketcode.backend_library.model.Book;
import com.rocketcode.backend_library.model.Loan;
import com.rocketcode.backend_library.service.BookService;
import com.rocketcode.backend_library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private LoanService loanService;


    @GetMapping("/getAll")
    public List<Book> getAllBooks(@RequestParam(value = "role", defaultValue = "USER") String role) {
        List<Book> books = bookService.getAllBooks();


        if (role.equals("ADMIN")) {
            for (Book book : books) {
                Loan loan = loanService.getLoanByBookId(book.getId());
                if (loan != null) {
                    book.setAvailable(false);
                } else {
                    book.setAvailable(true);
                }
            }
        } else {

            for (Book book : books) {
                Loan loan = loanService.getLoanByBookId(book.getId());
                if (loan != null) {
                    book.setAvailable(false);
                } else {
                    book.setAvailable(true);
                }
            }
        }
        return books;
    }

    @GetMapping("/getById/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }
}
