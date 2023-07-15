package com.study.gtnext.converter;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.LocalitaDTO;
import com.study.gtnext.entity.Localita;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class LocalitaConverter implements Converter<Localita,LocalitaDTO> {
    @Override
    public Localita convert(LocalitaDTO u) {
        Localita d = new Localita();
        d.setId(u.getId());
        d.setCitta(u.getCitta());
        d.setZona(u.getZona());
        return d;
    }

    @Override
    public LocalitaDTO reverseConvert(Localita u) {

        LocalitaDTO d = new LocalitaDTO();
        d.setId(u.getId());
        d.setCitta(u.getCitta());
        d.setZona(u.getZona());
        return d;
    }
}
