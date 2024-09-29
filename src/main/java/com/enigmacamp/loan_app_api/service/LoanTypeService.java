package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.request.LoanTypeRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTypeResponse;
import com.enigmacamp.loan_app_api.entity.LoanType;
import org.springframework.data.domain.Page;

public interface LoanTypeService {
    LoanTypeResponse createLoanType(LoanTypeRequest request);
    LoanTypeResponse getLoanTypeById(String id);
    Page<LoanTypeResponse> getAllLoanType(Integer page, Integer size);
    LoanTypeResponse updateLoanType(LoanType request);
    void deleteLoanType(String id);
}
