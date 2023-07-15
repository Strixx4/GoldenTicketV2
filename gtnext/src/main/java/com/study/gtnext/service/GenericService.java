package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.study.gtnext.converter.Converter;
import com.study.gtnext.entity.GenericEntity;

import lombok.Data;

@Data
public abstract class GenericService<  
                                    E extends GenericEntity,
                                    C extends Converter<E,D>,
                                    J extends JpaRepository<E,ID>,
                                    D,
                                    ID
                                    > {

    private final C converter;
    private final J repository;


    public D findByIdService(ID id) {
        return(D)converter.reverseConvert((E) repository.findById(id).get());
    }
    
    public D saveService(D dto){
        E e =  converter.convert(dto);
        return (D)converter.reverseConvert((E) repository.save(e));
    }


    public List<D> findAll() {
        List<E> entities = repository.findAll();
        List<D> dtos = new ArrayList<>();

        entities.stream().forEach(
                x -> {
                    dtos.add(converter.reverseConvert(x));
                });
        /* for (E e : entities){
            D dto= converter.reverseConvert(e);
            dtos.add(dto);
        } */
        
        return dtos;
    }

    public Page< E > findAllByPage(int page, int size, ID id){

        Pageable p= PageRequest.of(page,size);

        return getRepository().findAll(p);

    }
}
