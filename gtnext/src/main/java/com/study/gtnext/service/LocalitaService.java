package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.Citta;
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
    
    public List<Citta> listCitta(){
       List<String> ls = getRepository().findListCitta();
       List<Citta> lc = new ArrayList<>();
       ls.stream().forEach(
        x -> {
            Citta c = new Citta();
            c.setCitta(x);
            lc.add(c);
        }
    );
       return lc;
    }
}
