package com.rocketcode.backend_library.mapper;

import com.rocketcode.backend_library.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO users (name, email, password, role) VALUES (#{name}, #{email}, #{password}, #{role})")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User searchByEmail(String email);


    @Select("SELECT * FROM users WHERE username = #{username}")
    Optional<User> searchByUsername(@Param("username") String username);
}
