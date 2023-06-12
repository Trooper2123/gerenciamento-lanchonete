package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ItenRepository extends JpaRepository<Iten, Long> {
    void deleteById(Long id);

    Optional<Iten> findById(Long id);

    Iten findByName(String name);

    @Modifying
    @Query("update Iten set quantity = :quantity, update_time = :updateTime where id = :id")
    void updateQuantity (@Param("id") Long id, @Param("quantity") Integer quantity, LocalDateTime updateTime);
}
