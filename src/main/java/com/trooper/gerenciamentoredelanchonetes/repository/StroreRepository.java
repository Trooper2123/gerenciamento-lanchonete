package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StroreRepository extends JpaRepository<Store, Long> {
}
