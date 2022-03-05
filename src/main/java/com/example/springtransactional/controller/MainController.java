package com.example.springtransactional.controller;


import com.example.springtransactional.model.Telefone;
import com.example.springtransactional.model.User;
import com.example.springtransactional.service.TelefoneService;
import com.example.springtransactional.service.UserService;
import com.example.springtransactional.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private TelefoneService telefoneService ;

    @PostMapping(path="/add")
    public @ResponseBody User addNewUser (@RequestParam Integer idUser , @RequestParam String userName,
                                          @RequestParam String email, @RequestParam String bairro,
                                          @RequestParam String cep, @RequestParam(required = false) String endereco,
                                          @RequestParam Integer idEndereco) {
        return userService.salvar(idUser,userName,email,bairro,cep,endereco,idEndereco);
    }

    @GetMapping(path="/all")
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping(path="/add/comtransacao")
    public @ResponseBody User addNewUserComTransacao(@RequestParam Integer idUser , @RequestParam String userName,
                                          @RequestParam String email, @RequestParam String bairro,
                                          @RequestParam String cep, @RequestParam(required = false) String endereco,
                                          @RequestParam Integer idEndereco) {
        return userService.salvarComTransacao(idUser,userName,email,bairro,cep,endereco,idEndereco);
    }


    @PostMapping(path="/add/telefone/comtransacao")
    public @ResponseBody User addNewTelefoneComTransacao(@RequestBody  UserVO userVO ) {
        return userService.salvarTelefoneComTransacao(userVO);
    }

    @GetMapping(path="/telefone/id/{id}")
    public @ResponseBody Telefone getByPhoneId(@PathVariable Integer id) {
        return telefoneService.getById(id);
    }



}