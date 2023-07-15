package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.LocalitaDTO;
import com.study.gtnext.entity.Localita;
import com.study.gtnext.repository.LocalitaRepo;

import com.study.gtnext.converter.LocalitaConverter;

@Service
public class LocalitaService extends GenericService<Localita, 
LocalitaConverter, 
LocalitaRepo, 
LocalitaDTO, 
Long>{
    public LocalitaService(LocalitaConverter converter, LocalitaRepo repository){
        super(converter, repository);
    }
    public List<LocalitaDTO> findBigPosti(){
        List<Localita> entities = getRepository().findBigPosti();
        List<LocalitaDTO> dtos = new ArrayList<>();

        entities.stream().forEach(
                x -> {
                    dtos.add(getConverter().reverseConvert(x));
                }
        );
    
        return dtos;
    }
}
