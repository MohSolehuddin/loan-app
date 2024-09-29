package com.enigmacamp.loan_app_api.dto.response;

import com.enigmacamp.loan_app_api.constant.LoanStatus;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LoanTransactionDetailResponse {
    private String id;
    private LocalDateTime transactionDate;
    private Double nominal;
    private LoanStatus loanStatus;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
