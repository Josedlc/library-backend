package com.rocketcode.backend_library.service;

import com.rocketcode.backend_library.dto.LoginRequest;
import com.rocketcode.backend_library.dto.RegisterRequest;
import com.rocketcode.backend_library.dto.UserResponse;
import com.rocketcode.backend_library.exception.InvalidCredencialsException;
import com.rocketcode.backend_library.exception.NoExistingResourceException;
import com.rocketcode.backend_library.mapper.UserMapper;
import com.rocketcode.backend_library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public UserService(UserMapper mapper, PasswordEncoder encoder) {
        this.mapper = mapper;
        this.encoder = encoder;
    }

    public UserResponse register(RegisterRequest request) {
        if (mapper.searchByEmail(request.getEmail()) != null)
            throw new NoExistingResourceException("El email ya está registrado");

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encoder.encode(request.getPassword()));
        newUser.setRole(request.getRole());
        mapper.insertUser(newUser);

        return new UserResponse(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getRole());
    }

    public UserResponse login(LoginRequest request) {
        User user = mapper.searchByEmail(request.getEmail());
        if (user == null || !encoder.matches(request.getPassword(), user.getPassword()))
            throw new InvalidCredencialsException("Credenciales incorrectas");

        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }

    public User validateUser(String username, String password) {
        Optional<User> optionalUser = mapper.searchByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
             if (encoder.matches(password, user.getPassword())) {
                return user;
             }
        }
        return null;
    }
}
