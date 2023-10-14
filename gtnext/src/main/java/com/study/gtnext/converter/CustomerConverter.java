package com.study.gtnext.converter;

import org.springframework.stereotype.Service;

import com.study.gtnext.dto.CustomerDTO;
import com.study.gtnext.entity.Customer;

@Service
public class CustomerConverter implements Converter<Customer, CustomerDTO> {

    @Override
    public Customer convert(CustomerDTO u) {
        Customer c = new Customer();
        c.setId(u.getId());
        c.setNominativo(u.getNomininativo());
        c.setUsername(u.getUsername());
        return c;
    }

    @Override
    public CustomerDTO reverseConvert(Customer u) {
        CustomerDTO c = new CustomerDTO();
        c.setId(u.getId());
        c.setNomininativo(u.getNominativo());
        c.setUsername(u.getUsername());
        return c;
    }

}
