package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    public Page<EventoDTO> FindWithLimit(int page,int size){
        Page<Evento> pages = getRepository().findAll(PageRequest.of(page,size));
        List<EventoDTO> pagesDtoList = new ArrayList<>();
        pages.stream().forEach(
            x -> {pagesDtoList.add(getConverter().reverseConvert(x));}
        );
        Page<EventoDTO> pagesDto = new PageImpl<>(pagesDtoList);
        return pagesDto;
    }
}
