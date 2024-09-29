package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.request.CustomerRequest;
import com.enigmacamp.loan_app_api.dto.response.CustomerResponse;
import com.enigmacamp.loan_app_api.entity.Customer;
import org.springframework.data.domain.Page;


public interface CustomerService {
    CustomerResponse createCustomer(Customer customer);
    CustomerResponse getCustomerById(String id);
    Page<CustomerResponse> getAllCustomer(Integer page, Integer size);
    CustomerResponse updateCustomer(CustomerRequest customerRequest);
    void softDeleteCustomer(String id);
    Customer findCustomerOrThrowNotFound(String id);
}