package com.study.gtnext.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.ArtistaDTO;
import com.study.gtnext.entity.Artista;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Service
@NoArgsConstructor
public class ArtistaConverter implements Converter<Artista,ArtistaDTO>{
    @Override
    public Artista convert(ArtistaDTO u) {
        Artista d = new Artista();
        d.setId(u.getId());
        d.setNominativo(u.getNominativo());
        
        return d;
    }

    @Override
    public ArtistaDTO reverseConvert(Artista u) {
        ArtistaDTO d = new ArtistaDTO();
        d.setId(u.getId());
        d.setNominativo(u.getNominativo());
        return d;
    }
    public List<ArtistaDTO> LEToLD(List<Artista> la){
        List<ArtistaDTO> lda = new ArrayList<>();

        la.stream().forEach(
            x->{
                lda.add(reverseConvert(x));
            }
        );
        return lda;
    }
    public List<Artista> LDToLE(List<ArtistaDTO> la){
        List<Artista> lda = new ArrayList<>();

        la.stream().forEach(
            x->{
                lda.add(convert(x));
            }
        );
        return lda;
    }
}
