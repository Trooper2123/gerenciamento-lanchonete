package com.trooper.gerenciamentoredelanchonetes.repository;

import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import com.trooper.gerenciamentoredelanchonetes.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Purchase findByUserId(Long id);

    @Modifying
    @Query("update Purchase set status = :status where id = :id")
    void updateStatus (@Param("id") Long id, @Param("status") Status status);
}
