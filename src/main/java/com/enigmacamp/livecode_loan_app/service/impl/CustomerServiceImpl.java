package com.enigmacamp.livecode_loan_app.service.impl;

import com.enigmacamp.livecode_loan_app.entity.Customer;
import com.enigmacamp.livecode_loan_app.repository.CustomerRepository;
import com.enigmacamp.livecode_loan_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
}
