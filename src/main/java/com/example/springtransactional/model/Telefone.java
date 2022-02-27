package com.example.springtransactional.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer ddd;
    private Long phone;
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user ;

}
