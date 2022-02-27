package com.example.springtransactional.service;

import com.example.springtransactional.model.Endereco;
import com.example.springtransactional.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository ;

    public Endereco salvarEndereco(String bairro, String cep, String endereco, Integer idEndereco){
        Endereco end = createEndereco(idEndereco,bairro,cep,endereco);
        return enderecoRepository.save(end);
    }

    public Endereco createEndereco(Integer idEndereco, String bairro, String cep, String endereco){
        Endereco end = new Endereco();
        end.setId(idEndereco);
        end.setBairro(bairro);
        end.setCep(cep);
        end.setEndereco(endereco);
        return end;
    }


}
