package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Role;
import com.trooper.gerenciamentoredelanchonetes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User, String>{

    boolean findByRole(Role role);

    User findByEmail(String email);

    void deleteByEmail(String email);
}
