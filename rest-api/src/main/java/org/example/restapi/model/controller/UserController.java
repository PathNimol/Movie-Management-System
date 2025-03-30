package org.example.restapi.model.controller;

import org.example.restapi.model.entity.User;
import org.example.restapi.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    public static final List<User> USERS = new ArrayList<>();
    public static final AtomicLong AUTOMIC_LONG = new AtomicLong(4L);

    public UserController() {
        USERS.add(new User(1L, "Path Nimol", "Student"));
        USERS.add(new User(2L, "Leng Chingmony", "Class Leader"));
        USERS.add(new User(3L, "Kou Kimheng", "Kmeng Toch"));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return USERS;
    }

    @PostMapping
    public User saveUser(@RequestBody UserRequest request) {
        User user = new User(AUTOMIC_LONG.getAndIncrement(), request.getUsername(), request.getRole());
        USERS.add(user);
        return user;
    }

}
