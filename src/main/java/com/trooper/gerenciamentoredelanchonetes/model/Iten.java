package com.trooper.gerenciamentoredelanchonetes.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itens")
public class Iten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "store", nullable = false)
    private Store store;


}
