package com.study.gtnext.service;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.ArtistaConverter;
import com.study.gtnext.dto.ArtistaDTO;
import com.study.gtnext.entity.Artista;
import com.study.gtnext.repository.ArtistaRepo;

@Service
public class ArtistaService extends GenericService<Artista,
                                                    ArtistaConverter,
                                                    ArtistaRepo,
                                                    ArtistaDTO,
                                                    Long> {
    public ArtistaService(ArtistaConverter converter, ArtistaRepo repository){
        super(converter,repository);
    }
    
}
