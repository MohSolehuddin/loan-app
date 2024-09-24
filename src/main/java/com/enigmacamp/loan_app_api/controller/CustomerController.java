package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.dto.response.CustomerResponse;
import com.enigmacamp.loan_app_api.mapper.HTTPResponseMapper;
import com.enigmacamp.loan_app_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathApi.CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(PathApi.PATH_VAR_ID)
    public ResponseEntity<?> getCustomerById(@PathVariable String id){
        CustomerResponse customerResponse = customerService.getCustomerById(id);
        return HTTPResponseMapper.response(customerResponse, HttpStatus.OK, "Successfully get data by id");
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomer(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "5") Integer size){
        Page<CustomerResponse> responses = customerService.getAllCustomer(page, size);
//        List<CustomerResponse> customerResponseList = customerService.getAllCustomer(page,size);
        return HTTPResponseMapper.pagingResponse(responses, HttpStatus.OK, "Successfully get all data");
    }
}