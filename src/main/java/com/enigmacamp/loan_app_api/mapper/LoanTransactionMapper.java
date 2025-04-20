package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.LoanTransactionDetailResponse;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.entity.LoanTransaction;
import com.enigmacamp.loan_app_api.entity.LoanTransactionDetail;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LoanTransactionMapper {
    public static LoanTransactionResponse mapToResponse(LoanTransaction transaction) {
        List<LoanTransactionDetailResponse> loanTransactionDetailResponses =
                transaction.getLoanTransactionDetails() != null
                        ? transaction.getLoanTransactionDetails().stream()
                        .map(LoanTransactionDetailMapper::mapToResponse)
                        .toList()
                        : List.of();


        return LoanTransactionResponse.builder()
                .id(transaction.getId())
                .nominal(transaction.getNominal())
                .instalmentTypeId(
                        transaction.getInstalmentType() != null ? transaction.getInstalmentType().getId() : null)
                .loanTypeId(
                        transaction.getLoanType() != null ? transaction.getLoanType().getId() : null)
                .createdAt(transaction.getCreatedAt())
                .updateAt(transaction.getUpdatedAt())
                .approvedStatus(
                        transaction.getApprovalStatus() != null ? transaction.getApprovalStatus().toString() : null)
                .approvedAt(transaction.getApprovedAt())
                .approvedBy(transaction.getApprovedBy())
                .customerId(
                        transaction.getCustomer() != null ? transaction.getCustomer().getId() : null)
                .transactionDetailResponses(loanTransactionDetailResponses)
                .build();
    }
}
