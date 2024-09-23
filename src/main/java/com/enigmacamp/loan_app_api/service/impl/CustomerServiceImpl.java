package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.dto.request.CustomerRequest;
import com.enigmacamp.loan_app_api.dto.response.CustomerResponse;
import com.enigmacamp.loan_app_api.entity.Customer;
import com.enigmacamp.loan_app_api.mapper.CustomerMapper;
import com.enigmacamp.loan_app_api.repository.CustomerRepository;
import com.enigmacamp.loan_app_api.service.CustomerService;
import com.enigmacamp.loan_app_api.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;

    public CustomerResponse createCustomer(Customer customer){
        try {
            validationUtil.validate(customer);
            Customer newCustomer = customerRepository.save(customer);
            return CustomerMapper.mapToCustomerResponse(newCustomer);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed creating new customer");
        }
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        Customer customer = findCustomerOrThrowNotFound(id);
        return CustomerMapper.mapToCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Don't customer data");
        }
        return customers.stream().map(CustomerMapper::mapToCustomerResponse).toList();
    }

    private Customer findCustomerOrThrowNotFound(String id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }
}