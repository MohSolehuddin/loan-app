package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.LoanTransactionDetailResponse;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.entity.LoanTransaction;
import com.enigmacamp.loan_app_api.entity.LoanTransactionDetail;

public class LoanTransactionMapper {
    public static LoanTransactionResponse mapToResponse(LoanTransaction transaction){
        LoanTransactionDetailResponse loanTransactionDetailResponse = LoanTransactionDetailMapper.mapToResponse((LoanTransactionDetail) transaction.getLoanTransactionDetails());
        return LoanTransactionResponse.builder()
                .id(transaction.getId())
                .nominal(transaction.getNominal())
                .instalmentTypeId(transaction.getInstalmentType().getId())
                .loanTypeId(transaction.getLoanType().getId())
                .createdAt(transaction.getCreatedAt())
                .updateAt(transaction.getUpdatedAt())
                .approvedStatus(transaction.getApprovalStatus().toString())
                .approvedAt(transaction.getApprovedAt())
                .approvedBy(transaction.getApprovedBy())
                .customerId(transaction.getCustomer().getId())
                .transactionDetailResponses(loanTransactionDetailResponse)
                .build();
    }
}
