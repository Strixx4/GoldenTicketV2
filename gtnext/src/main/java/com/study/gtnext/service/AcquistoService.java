package com.study.gtnext.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.AcquistoConverter;
import com.study.gtnext.dto.AcquistoDTO;
import com.study.gtnext.entity.Acquisto;
import com.study.gtnext.entity.Carrello;
import com.study.gtnext.repository.AcquistoRepo;

@Service
public class AcquistoService extends GenericService<Acquisto, AcquistoConverter, AcquistoRepo, AcquistoDTO, Long> {
    private final CarrelloService carrelloService;

    public AcquistoService(AcquistoConverter converter, AcquistoRepo repository, CarrelloService cs) {
        super(converter, repository);
        this.carrelloService = cs;
    }

    public List<AcquistoDTO> findByUser(Long id) {
        List<Acquisto> la = getRepository().findByUserName(id);
        return la.stream().map(x -> getConverter().reverseConvert(x)).collect(Collectors.toList());
    }

    public void save(Long carrelloID) {
        Acquisto a = new Acquisto();
        Optional<Carrello> c = carrelloService.findById(carrelloID);
        if (c.isPresent()) {
            a.setCustomer(c.get().getCustomer());
            a.setEvento(c.get().getEvento());
            a.setIdentificativo(c.get().getIdentificativo());
            a.setPrezzo(c.get().getPrezzo());
            getRepository().save(a);
        }
    }

    public void saveList(List<String> ids) {
        ids.stream().forEach(x -> {
            save(Long.parseLong(x));
        });
    }
}
