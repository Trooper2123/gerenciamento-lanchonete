package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
