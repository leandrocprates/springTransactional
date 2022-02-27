package com.example.springtransactional.repository;

import com.example.springtransactional.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

}
