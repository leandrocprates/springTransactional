package com.example.springtransactional.service;

import com.example.springtransactional.model.Telefone;
import com.example.springtransactional.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository telefoneRepository ;

    public Telefone getById(int idTelefone){
        return telefoneRepository.findById(idTelefone).orElse(null);
    }



}
