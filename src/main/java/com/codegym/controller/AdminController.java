package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private IUserService userService;
    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> showListUser(){
        Iterable<User>users=userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
