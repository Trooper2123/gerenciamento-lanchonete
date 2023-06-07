package com.trooper.gerenciamentoredelanchonetes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", nullable = false)
    private User userId;

    @Column(name = "itens", nullable = false)
    private List<Iten> itens;

}
