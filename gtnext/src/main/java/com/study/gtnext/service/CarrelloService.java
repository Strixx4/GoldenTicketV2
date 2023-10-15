package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.CarrelloConverter;
import com.study.gtnext.dto.CarrelloDTO;
import com.study.gtnext.entity.Carrello;
import com.study.gtnext.entity.Customer;
import com.study.gtnext.entity.Evento;
import com.study.gtnext.repository.CarrelloRepo;

@Service
public class CarrelloService extends GenericService<Carrello, CarrelloConverter, CarrelloRepo, CarrelloDTO, Long> {
    private final EventoService eventoService;
    private final CustomerService customerService;

    public CarrelloService(CarrelloConverter converter, CarrelloRepo repository, EventoService es, CustomerService cs) {
        super(converter, repository);
        this.eventoService = es;
        this.customerService = cs;
    }

    public List<CarrelloDTO> findByUser(Long id) {
        List<Carrello> l = getRepository().findByUserName(id);
        List<CarrelloDTO> lc = new ArrayList<>();
        lc = l.stream().map(x -> getConverter().reverseConvert(x)).collect(Collectors.toList());
        return lc;
    }

    public Optional<Carrello> findById(Long id) {
        return getRepository().findById(id);
    }

    public void delete(Long idBiglietto) {
        getRepository().deleteById(idBiglietto);
    }

    public void deleteList(List<String> ids) {
        ids.stream().forEach(id -> {
            delete(Long.parseLong(id));
        });
    }

    public boolean save(Long idUser, Long idEvento) {
        Carrello c = new Carrello();
        Optional<Evento> e = eventoService.findById(idEvento);
        Optional<Customer> u = customerService.findById(idUser);

        Random r = new Random();

        if (e.isPresent() && u.isPresent()) {
            c.setEvento(e.get());
            c.setCustomer(u.get());
        } else
            return false;

        c.setIdentificativo("fila" + filaCasuale(r.nextInt(0, 5)) + " posto " + idEvento);
        c.setPrezzo(prezzo(r.nextInt(0, 5)));
        getRepository().save(c);
        return true;
    }

    private double prezzo(int nextInt) {
        return 5 * nextInt + 50.86;
    }

    private String filaCasuale(int c) {
        switch (c) {
            case 1:
                return "A";

            case 2:
                return "B";

            case 3:
                return "C";

            case 4:
                return "D";

            default:
                return "E";

        }
    }
}
