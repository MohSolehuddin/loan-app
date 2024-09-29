package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.dto.request.LoanTypeRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTypeResponse;
import com.enigmacamp.loan_app_api.entity.LoanType;
import com.enigmacamp.loan_app_api.mapper.HTTPResponseMapper;
import com.enigmacamp.loan_app_api.service.LoanTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathApi.LOAN_TYPE)
@RequiredArgsConstructor
public class LoanTypeController {
    private final LoanTypeService loanTypeService;

    @GetMapping
    public ResponseEntity<?> getAllLoanType(@RequestParam(defaultValue = "1", required = false) Integer page,@RequestParam(required = false, defaultValue = "5") Integer size){
        Page<LoanTypeResponse> response = loanTypeService.getAllLoanType(page, size);
        return HTTPResponseMapper.pagingResponse(response, HttpStatus.OK, "Successfully grt all data loan type");
    }
    @GetMapping(PathApi.PATH_VAR_ID)
    public ResponseEntity<?> getLoanTypeById(@PathVariable String id){
        LoanTypeResponse response = loanTypeService.getLoanTypeById(id);
        return HTTPResponseMapper.response(response, HttpStatus.OK, "Successfully get data loan by id");
    }
    @PutMapping
    public ResponseEntity<?> updateLoanType(@RequestBody LoanType request){
        LoanTypeResponse response = loanTypeService.updateLoanType(request);
        return HTTPResponseMapper.response(response, HttpStatus.OK, "Successfully updating data laon type");
    }
    @PostMapping
    public ResponseEntity<?> addLoanType(@RequestBody LoanTypeRequest request){
        LoanTypeResponse response = loanTypeService.createLoanType(request);
        return HTTPResponseMapper.response(response, HttpStatus.CREATED, "Successfully creating loan type");
    }
    @DeleteMapping(PathApi.PATH_VAR_ID)
    public ResponseEntity<?> deleteLoanType(@PathVariable String id){
        loanTypeService.deleteLoanType(id);
        return HTTPResponseMapper.response(null, HttpStatus.OK,"Successfully deleting loan type data");
    }
}
