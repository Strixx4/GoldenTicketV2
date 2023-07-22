package com.study.gtnext.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.EventoDTO;
import com.study.gtnext.entity.Evento;

import lombok.Data;

@Data
@Service
public class EventoConverter implements Converter<Evento,EventoDTO>{
    
    private final LocalitaConverter lc;
    private final ArtistaConverter la;
	
    @Override
    public Evento convert(EventoDTO d) {
        Evento e = new Evento();
        e.setId(d.getId());
        e.setNome(d.getNome());
        e.setTipologia(d.getTipologia());
        e.setGenere(d.getGenere());
        e.setData(d.getData());
        e.setLocandina(d.getLocandina());
        e.setLocalita(lc.convert(d.getLocalita()));
        e.setArtisti(la.LDToLE(d.getArtisti()));
        return e;
    }

    @Override
    public EventoDTO reverseConvert(Evento d) {

        EventoDTO e = new EventoDTO();
        e.setId(d.getId());
        e.setNome(d.getNome());
        e.setTipologia(d.getTipologia());
        e.setGenere(d.getGenere());
        e.setData(d.getData());
        e.setLocandina(d.getLocandina());
        e.setLocalita(lc.reverseConvert(d.getLocalita()));
        e.setArtisti(la.LEToLD(d.getArtisti()));
        return e;
    }

    public List<EventoDTO> reverseConvertList(List<Evento> le){
        List<EventoDTO> lde = new ArrayList<>();
        le.stream().forEach(
            x->{
                lde.add(reverseConvert(x));
            }
        );
        return lde;
    }
}
