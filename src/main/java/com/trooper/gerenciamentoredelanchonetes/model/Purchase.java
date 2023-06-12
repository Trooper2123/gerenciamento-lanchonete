package com.trooper.gerenciamentoredelanchonetes.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", nullable = false, length = 100)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "iten", nullable = false)
    private Long itenId;

    @Column(name = "itenQuantity", nullable = false)
    private Integer itenQuantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "updatedAt", nullable = true)
    private LocalDateTime updatedAt;

}
