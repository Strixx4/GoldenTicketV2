package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.study.gtnext.converter.EventoConverter;
import com.study.gtnext.dto.EventoDTO;
import com.study.gtnext.dto.Tipologia;
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

    public Page<EventoDTO> FindByCitta(int page,int size,String citta){
        Page<Evento> pages = getRepository().findByCitta(PageRequest.of(page,size),citta);
        List<EventoDTO> pagesDtoList = new ArrayList<>();
        pages.stream().forEach(
            x -> {pagesDtoList.add(getConverter().reverseConvert(x));}
        );
        Page<EventoDTO> pagesDto = new PageImpl<>(pagesDtoList);
        return pagesDto;
    }

    public List<Tipologia> findTipologia(){
        List<String> ls=getRepository().findTipologia();
        List<Tipologia> lt= new ArrayList<>();
        ls.stream().forEach(
            x->{
                Tipologia t = new Tipologia();
                t.setTipologia(x);
                lt.add(t);
            }
        );
        return lt;
    }
    public Page<EventoDTO> FindByTipologia(int page,int size,String tipologia){
        Page<Evento> pages = getRepository().findByTipologia(PageRequest.of(page,size),tipologia);
        List<EventoDTO> pagesDtoList = new ArrayList<>();
        pages.stream().forEach(
            x -> {pagesDtoList.add(getConverter().reverseConvert(x));}
        );
        Page<EventoDTO> pagesDto = new PageImpl<>(pagesDtoList);
        return pagesDto;
    }
}
