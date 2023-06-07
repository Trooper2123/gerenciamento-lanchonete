package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItenRepository extends JpaRepository<Iten, Long> {
}
