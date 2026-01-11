package com.taskmanager.app.controller;

import com.taskmanager.app.entity.User;
import com.taskmanager.app.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    
    
    @GetMapping
    public List<User> GetUsers() {
    	return userService.getUsers();
    	
    }
}
