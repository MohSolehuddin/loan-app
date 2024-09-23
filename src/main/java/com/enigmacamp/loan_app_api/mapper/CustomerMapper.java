package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.request.CustomerRequest;
import com.enigmacamp.loan_app_api.dto.response.CustomerResponse;
import com.enigmacamp.loan_app_api.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.sql.Date;

public class CustomerMapper {
    public static Customer mapTocustomer(CustomerRequest request){
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .dateOfBirth(Date.valueOf(request.getDateOfBirth()))
                .build();
    }
    public static CustomerResponse mapToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .id(customer.getId())
                .status(customer.getStatus())
                .phone(customer.getPhone())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .build();
    }
    public static ResponseEntity<?> HTTPResponse(){
        return null;
    }
}