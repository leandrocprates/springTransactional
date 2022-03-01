package com.example.springtransactional.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonBackReference // evita loop no retorno do json
    private User user ;

}
