package com.example.springtransactional.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @OneToMany(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Endereco> enderecos ;

    @OneToMany(mappedBy =  "user" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Telefone> telefones;


}