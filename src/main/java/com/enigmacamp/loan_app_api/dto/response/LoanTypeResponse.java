package com.enigmacamp.loan_app_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LoanTypeResponse {
    private String id;
    private String type;
    private Long maxLoan;
}
