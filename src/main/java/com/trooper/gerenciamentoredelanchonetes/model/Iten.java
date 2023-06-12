package com.trooper.gerenciamentoredelanchonetes.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "itens")
public class Iten {


    @Id
    @Column(name = "iten_id", nullable = false, length = 100)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification", nullable = false)
    private ItenClassification itenClassification;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column( name ="update_time", nullable = true)
    private LocalDateTime updateTime;
}
