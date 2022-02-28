package com.example.springtransactional.mapper;

import com.example.springtransactional.model.Telefone;
import com.example.springtransactional.model.User;
import com.example.springtransactional.vo.TelefoneVO;
import com.example.springtransactional.vo.UserVO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelefoneMapper {

    @Bean
    public ModelMapper telefoneModelMapper(){
        ModelMapper telefoneModelMapper = new ModelMapper();

        PropertyMap<TelefoneVO, Telefone> telefoneVoToUser = new PropertyMap<TelefoneVO, Telefone>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setDdd(source.getDdd());
                map().setPhone(source.getPhone());
                map().setTipo(source.getTipo());
            }
        };
        telefoneModelMapper.addMappings(telefoneVoToUser);
        return telefoneModelMapper ;
    }


    public Converter<List<TelefoneVO>,List<Telefone>> converterListTelefone = new AbstractConverter<List<TelefoneVO>, List<Telefone>>() {

        @Override
        protected List<Telefone> convert(List<TelefoneVO> telefoneVOS) {
            ModelMapper  telefoneModelMapper =  telefoneModelMapper() ;
            ArrayList<Telefone> arrayListTelefone = new ArrayList<>();

            for (TelefoneVO telefoneVO: telefoneVOS){
                Telefone telefone  = telefoneModelMapper.map(telefoneVO,Telefone.class);
                arrayListTelefone.add(telefone);
            }
            return arrayListTelefone;
        }
    };

}
