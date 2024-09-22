package com.enigmacamp.loan_app_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LoanTransactionResponse {
    private String id;
    private String loanTypeId;
    private String instalmentTypeId;
    private String customerId;
    private Long nominal;
    private String approvedAt;
    private String approvedBy;
    private String approvedStatus;
    private String transactionDetailResponses;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
