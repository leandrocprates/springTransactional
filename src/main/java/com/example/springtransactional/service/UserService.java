package com.example.springtransactional.service;

import com.example.springtransactional.model.Endereco;
import com.example.springtransactional.model.User;
import com.example.springtransactional.repository.UserRepository;
import com.example.springtransactional.vo.TelefoneVO;
import com.example.springtransactional.vo.UserVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    EnderecoService enderecoService ;

    @Autowired
    UserRepository userRepository;

    @Autowired
    @Qualifier("userModelMapper")
    ModelMapper userModelMapper ;

    public User salvar(Integer idUser , String userName, String email, String bairro, String cep, String endereco, Integer idEndereco){
        User n = new User();
        n.setId(idUser);
        n.setName(userName);
        n.setEmail(email);
        Endereco end = enderecoService.createEndereco(idEndereco, bairro, cep, endereco);
        n.setEnderecos(new ArrayList<>(){{add(end);}});
        return userRepository.save(n);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getById(Integer id ){
        return userRepository.findById(id).orElse(null);
    }



    @Transactional
    public User salvarComTransacao(Integer idUser , String userName, String email, String bairro, String cep, String endereco, Integer idEndereco){
        User n = new User();
        n.setId(idUser);
        n.setName(userName);
        n.setEmail(email);

        User userNew = userRepository.save(n);

        Endereco end = enderecoService.salvarEndereco(bairro,cep,endereco,idEndereco);
        userNew.setEnderecos(new ArrayList<>(){{add(end);}});
        userNew = userRepository.save(userNew);

        return userNew ;
    }


    public User salvarTelefoneComTransacao(UserVO userVO){
        User user = userModelMapper.map(userVO,User.class);
        return userRepository.save(user);
    }



}
