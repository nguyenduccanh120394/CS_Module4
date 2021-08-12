package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("")
    public ResponseEntity<Optional<User>> createUser(@RequestBody User user){
        String newPassword = passwordEncoder.encode(user.getPassword());
        userRepository.save(new User(user.getUsername(),newPassword,user.getFullName(),user.getEmail(),user.getAddress(),user.getPhone(),user.getImage(),user.getRoles()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
