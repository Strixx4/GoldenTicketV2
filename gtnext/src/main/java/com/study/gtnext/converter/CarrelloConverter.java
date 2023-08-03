package com.study.gtnext.converter;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.CarrelloDTO;
import com.study.gtnext.entity.Carrello;

import lombok.Data;

@Data
@Service
public class CarrelloConverter implements Converter<Carrello, CarrelloDTO> {
    private final EventoConverter ec;

    @Override
    public Carrello convert(CarrelloDTO u) {
        Carrello c = new Carrello();
        c.setId(u.getId());
        c.setIdentificativo(u.getIdentificativo());
        c.setPrezzo(u.getPrezzo());
        c.setEvento(ec.convert(u.getEvento()));
        return c;
    }

    @Override
    public CarrelloDTO reverseConvert(Carrello u) {
        CarrelloDTO c = new CarrelloDTO();
        c.setId(u.getId());
        c.setIdentificativo(u.getIdentificativo());
        c.setPrezzo(u.getPrezzo());
        c.setEvento(ec.reverseConvert(u.getEvento()));
        return c;
    }

}
