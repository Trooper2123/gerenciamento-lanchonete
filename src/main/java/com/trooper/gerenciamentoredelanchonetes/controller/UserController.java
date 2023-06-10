package com.trooper.gerenciamentoredelanchonetes.controller;

import com.trooper.gerenciamentoredelanchonetes.model.User;
import com.trooper.gerenciamentoredelanchonetes.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")//pre-path
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @DeleteMapping("{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteByEmail(email);
    }

    @GetMapping("{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

}
