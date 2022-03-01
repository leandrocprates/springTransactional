package com.example.springtransactional.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    //@ManyToOne(fetch = FetchType.LAZY)
    //User user ;//se colocar da problema no retorno em loop

}
