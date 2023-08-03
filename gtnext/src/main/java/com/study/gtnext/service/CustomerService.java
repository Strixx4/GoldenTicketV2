package com.study.gtnext.service;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.CustomerConverter;
import com.study.gtnext.dto.CustomerDTO;
import com.study.gtnext.entity.Customer;
import com.study.gtnext.repository.CustomerRepo;

@Service
public class CustomerService extends GenericService<
                                                    Customer,
                                                    CustomerConverter,
                                                    CustomerRepo,
                                                    CustomerDTO,
                                                    Long
                                                    >{

    public CustomerService(CustomerConverter converter, CustomerRepo repository) {
        super(converter, repository);
    }

    public Customer findCustomer(String user) throws Exception{
        Customer c = getRepository().findByUsername(user);
        if(c != null){
            return c;
        }else{
            throw new Exception("User not found");
        }
    }
    public CustomerDTO findByUser(String user) throws Exception{
         Customer c = getRepository().findByUsername(user);
        if(c != null){
            return getConverter().reverseConvert(c);
        }else{
            throw new Exception("User not found");
        }
    }
    
}
