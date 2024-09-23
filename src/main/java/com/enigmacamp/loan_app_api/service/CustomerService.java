package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.response.CustomerResponse;
import com.enigmacamp.loan_app_api.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(Customer customer);
    CustomerResponse getCustomerById(String id);
    List<CustomerResponse> getAllCustomer();

}