package com.study.gtnext.converter;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.AcquistoDTO;
import com.study.gtnext.entity.Acquisto;

import lombok.Data;

@Data
@Service
public class AcquistoConverter implements Converter<Acquisto, AcquistoDTO> {
    private final EventoConverter eventoConverter;

    @Override
    public Acquisto convert(AcquistoDTO u) {
        Acquisto a = new Acquisto();
        a.setId(u.getId());
        a.setData_acquisto(u.getData_acquisto());
        a.setPrezzo(u.getPrezzo());
        a.setIdentificativo(u.getIdentificativo());
        a.setEvento(eventoConverter.convert(u.getEvento()));
        return a;
    }

    @Override
    public AcquistoDTO reverseConvert(Acquisto u) {
        AcquistoDTO a = new AcquistoDTO();
        a.setId(u.getId());
        a.setData_acquisto(u.getData_acquisto());
        a.setPrezzo(u.getPrezzo());
        a.setIdentificativo(u.getIdentificativo());
        a.setEvento(eventoConverter.reverseConvert(u.getEvento()));
        return a;
    }

}
