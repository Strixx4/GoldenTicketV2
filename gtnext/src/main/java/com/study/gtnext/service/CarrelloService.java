package com.study.gtnext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> findByUser(String username) {
        List<Carrello> lc = getRepository().findByUserName(username);
        if (lc.isEmpty()) {
            String responseMessage = "Nessun carrello trovato per l'utente " + username;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }else{
            List<CarrelloDTO> lcd = new ArrayList<>();
            lc.forEach(x -> {
                lcd.add(getConverter().reverseConvert(x));
            });
            return ResponseEntity.ok(lcd);
        }
    }

}
