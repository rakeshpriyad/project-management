package com.project.mgmt.service.controller;

import com.project.mgmt.service.domain.User;
import com.project.mgmt.service.dto.UserRequest;
import com.project.mgmt.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User save(@RequestBody UserRequest user) {
        return userService.save(user).get();
    }

    @PutMapping("/users")
    public User update(@RequestBody UserRequest user) {
        return userService.save(user).get();
    }
}

