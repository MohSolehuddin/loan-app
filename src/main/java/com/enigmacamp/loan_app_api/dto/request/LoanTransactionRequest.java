package com.enigmacamp.loan_app_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LoanTransactionRequest {
    private String loanTypeId;
    private String instalmentType;
    private String customerId;
    private Long nominal;
}
