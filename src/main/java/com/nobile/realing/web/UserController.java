package com.nobile.realing.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobile.realing.entity.User;
import com.nobile.realing.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
    
}
