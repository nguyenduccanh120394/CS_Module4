package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.role.IRoleService;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> showListUser(){
        Iterable<User>users=userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/roles")
    public ResponseEntity<Iterable<Role>>getRole(){
        Iterable<Role>roles=roleService.findAll();
        return new ResponseEntity<>(roles,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User>user=userService.findById(id);
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User>edit(@PathVariable Long id,@RequestBody User user){
        Optional<User>userCurrent=userService.findById(id);
        if (!userCurrent.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User>delete(@PathVariable Long id){
        Optional<User>user=userService.findById(id);
        if (!user.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }
    @GetMapping("/username")
    public ResponseEntity<Iterable<User>> searchByUsername(@RequestParam("key") String key){
        Iterable<User>users=userService.findByUsernameContaining(key);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/address")
    public ResponseEntity<Iterable<User>> sortByAddress(){
        Iterable<User>users=userService.sortByAddress();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/names")
    public ResponseEntity<Iterable<User>> sortByUsername(){
        Iterable<User>users=userService.sortByUsername();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
