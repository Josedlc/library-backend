package com.rocketcode.backend_library.mapper;

import com.rocketcode.backend_library.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM books")
    List<Book> getAllBooks();

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book getBookById(int id);

    @Insert("INSERT INTO books (title, author, available) VALUES (#{title}, #{author}, #{available})")
    void insertBook(Book book);

    @Update("UPDATE books SET available = #{available} WHERE id = #{id}")
    void updateBookAvailability(int id, boolean available);
}
