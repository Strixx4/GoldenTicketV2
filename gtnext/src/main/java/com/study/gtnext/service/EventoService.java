package com.study.gtnext.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.EventoConverter;
import com.study.gtnext.dto.EventoDTO;
import com.study.gtnext.entity.Evento;
import com.study.gtnext.repository.EventoRepo;

@Service
public class EventoService extends GenericService<
                                                  Evento,
                                                  EventoConverter,
                                                  EventoRepo,
                                                  EventoDTO,
                                                  Long>

                                                {
    public EventoService(EventoConverter converter,EventoRepo repository){
        super(converter,repository);
    }
    public List<EventoDTO> FindWithLimit(){
        List<Evento> le = getRepository().FindWithLimit();
        List<EventoDTO> lde = getConverter().reverseConvertList(le);
        return lde;
    }
}
