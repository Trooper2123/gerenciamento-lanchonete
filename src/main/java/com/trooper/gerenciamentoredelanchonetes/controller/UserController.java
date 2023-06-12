package com.trooper.gerenciamentoredelanchonetes.controller;

import com.trooper.gerenciamentoredelanchonetes.model.User;
import com.trooper.gerenciamentoredelanchonetes.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")//pre-path
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @DeleteMapping("{email}")
    public ResponseEntity deleteUser(@PathVariable String email) throws Exception {
     userService.deleteByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{email}")
    public ResponseEntity findUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.findUserByEmail(email),HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity  findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) throws Exception {
        return new ResponseEntity(userService.saveUser(user), HttpStatus.OK);
    }

}
