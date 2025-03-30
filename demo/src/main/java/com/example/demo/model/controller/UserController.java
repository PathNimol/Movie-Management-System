package com.example.demo.model.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private static final List<User> USERS = new ArrayList<>();
    private static final AtomicLong ATOMIC_LONG = new AtomicLong(5L);

    public UserController(){
        USERS.add(new User(1L, "Nimol", "Student"));
        USERS.add(new User(2L, "Ching", "Meee"));
        USERS.add(new User(3L, "Kimheng", "Kmeng Bek Sloy"));
        USERS.add(new User(4L, "Thavorn", "Kmeng Toch"));
    }

    //Get all user
    @GetMapping
    public List<User> getAllUsers(){
        return USERS;
    }

    //Add User to list
    @PostMapping
    public User saveUser(@RequestBody UserRequest request){
        User user = new User(ATOMIC_LONG.getAndIncrement(), request.getUsername(), request.getRole());
        USERS.add(user);
        return user;
    }

    //Update user
    //Search by name
    //Delete by ID
    //
}
