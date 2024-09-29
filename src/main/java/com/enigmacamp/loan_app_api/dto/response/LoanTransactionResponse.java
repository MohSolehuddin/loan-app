package com.enigmacamp.loan_app_api.dto.response;

import com.enigmacamp.loan_app_api.constant.LoanStatus;
import com.enigmacamp.loan_app_api.entity.LoanTransactionDetail;
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
    private Double nominal;
    private LocalDateTime approvedAt;
    private String approvedBy;
    private String approvedStatus;
    private LoanTransactionDetailResponse transactionDetailResponses;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
