package com.trooper.gerenciamentoredelanchonetes.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", nullable = false, length = 100)
    private Long id;

    @JoinColumn(name = "user_id")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @JoinColumn(name = "iten_id")
    @Column(name = "iten_id", nullable = false)
    private ArrayList<Iten> itensId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "updatedeAt", nullable = false)
    private LocalDateTime updatedAt;

}
