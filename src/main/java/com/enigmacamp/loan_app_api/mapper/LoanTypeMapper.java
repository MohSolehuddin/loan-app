package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.LoanTypeResponse;
import com.enigmacamp.loan_app_api.entity.LoanType;

public class LoanTypeMapper {
    public static LoanTypeResponse mapToLoanTypeResponse(LoanType loanType){
        return LoanTypeResponse.builder()
                .id(loanType.getId())
                .type(loanType.getType())
                .maxLoan(loanType.getMaxLoan())
                .build();
    }
}
