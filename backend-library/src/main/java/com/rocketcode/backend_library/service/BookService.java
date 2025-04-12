package com.rocketcode.backend_library.service;

import com.rocketcode.backend_library.mapper.BookMapper;
import com.rocketcode.backend_library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    public void createBook(Book book) {
        bookMapper.insertBook(book);
    }

    public void updateBookAvailability(int id, boolean available) {
        bookMapper.updateBookAvailability(id, available);
    }
}
