package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.entity.Customer;
import com.enigmacamp.loan_app_api.repository.CustomerRepository;
import com.enigmacamp.loan_app_api.service.CustomerService;
import com.enigmacamp.loan_app_api.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;

    public Customer createCustomer(Customer customer){
        try {
            validationUtil.validate(customer);
            return customerRepository.save(customer);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed creating new customer");
        }
    }
}
