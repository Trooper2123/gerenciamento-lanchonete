package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItenRepository extends JpaRepository<Iten, Long> {
    void deleteById(Long id);

    Optional<Iten> findById(Long id);

    Iten findByName(String name);
}
