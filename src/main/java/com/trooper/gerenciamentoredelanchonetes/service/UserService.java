package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Role;
import com.trooper.gerenciamentoredelanchonetes.model.User;
import com.trooper.gerenciamentoredelanchonetes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) throws Exception {
        Random random = new Random();

           if(userRepository.findByEmail(user.getEmail()) == null) {
            if(userRepository.findByRole(Role.MANAGER) == null){
                user.setRole(Role.MANAGER);
            } else {
                user.setRole(Role.USER);
            }
        } else {
               throw new Exception("Email já cadastrado");
           }
           user.setCreateTime(LocalDateTime.now());
        user.setId(random.nextLong());
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }


    @Override
    @Transactional
    public void deleteByEmail(String email) throws Exception {
        if(userRepository.findByEmail(email).getRole() != Role.MANAGER){
            userRepository.deleteByEmail(email);
        }else{
            throw new Exception("Este usuário não pode ser deletado");
        }
    }


}
