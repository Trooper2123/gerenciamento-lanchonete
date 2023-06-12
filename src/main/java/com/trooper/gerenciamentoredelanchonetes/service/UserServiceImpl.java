package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.User;

import java.util.List;


public interface UserServiceImpl {

    User saveUser(User user) throws Exception;

    List<User>  findAllUsers();

    void deleteByEmail(String email) throws Exception;

    User findUserByEmail(String email);

}
