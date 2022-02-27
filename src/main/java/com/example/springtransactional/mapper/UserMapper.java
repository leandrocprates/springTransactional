package com.example.springtransactional.mapper;


import com.example.springtransactional.model.User;
import com.example.springtransactional.vo.UserVO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Bean
    public ModelMapper userModelMapper(){
        ModelMapper userModelMapper = new ModelMapper();

        PropertyMap<UserVO, User> userVoToUser = new PropertyMap<UserVO, User>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setEmail(source.getEmail());
                map().setName(source.getName());
            }
        };
        userModelMapper.addMappings(userVoToUser);
        return userModelMapper ;
    }


}
