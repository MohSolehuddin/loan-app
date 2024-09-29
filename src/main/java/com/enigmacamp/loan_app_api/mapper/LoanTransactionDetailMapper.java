package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.LoanTransactionDetailResponse;
import com.enigmacamp.loan_app_api.entity.LoanTransactionDetail;


public class LoanTransactionDetailMapper {
    public static LoanTransactionDetailResponse mapToResponse(LoanTransactionDetail transactionDetail){
        return LoanTransactionDetailResponse.builder()
                .id(transactionDetail.getId())
                .loanStatus(transactionDetail.getLoanStatus())
                .transactionDate(transactionDetail.getTransactionDate())
                .nominal(transactionDetail.getNominal())
                .updateAt(transactionDetail.getUpdatedAt())
                .createAt(transactionDetail.getCreatedAt())
                .build();
    }
}
