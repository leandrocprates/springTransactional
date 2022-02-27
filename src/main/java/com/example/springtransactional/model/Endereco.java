package com.example.springtransactional.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Cep esta nulo")
    private String cep ;
    @NotNull(message = "Endereco esta nulo")
    private String endereco ;
    private String bairro ;

}
