package com.example.springtransactional.vo;

import lombok.Getter;
import lombok.Setter;
import java.util.List ;

@Getter
@Setter
public class UserVO {
    private Integer id;
    private String name;
    private String email;

    private List<TelefoneVO> telefone ;

}
