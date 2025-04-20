package com.enigmacamp.loan_app_api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LoanTransactionRequest {
    @NotNull
    private String loanTypeId;
    @NotNull
    private String instalmentTypeId;
    @NotNull
    private String customerId;
    @NotNull
    private Double nominal;
}
