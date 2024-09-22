package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.entity.Customer;
import com.enigmacamp.loan_app_api.repository.CustomerRepository;
import com.enigmacamp.loan_app_api.service.CustomerService;
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
