package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.CarrelloConverter;
import com.study.gtnext.dto.CarrelloDTO;
import com.study.gtnext.entity.Carrello;
import com.study.gtnext.repository.CarrelloRepo;

@Service
public class CarrelloService extends GenericService<Carrello, CarrelloConverter, CarrelloRepo, CarrelloDTO, Long> {

    public CarrelloService(CarrelloConverter converter, CarrelloRepo repository) {
        super(converter, repository);
    }

    public List<CarrelloDTO> findById(Long id) {
        List<Carrello> l = getRepository().findByUserName(id);
        List<CarrelloDTO> lc = new ArrayList<>();
        lc = l.stream().map(x -> getConverter().reverseConvert(x)).collect(Collectors.toList());
        return lc;
    }

}
