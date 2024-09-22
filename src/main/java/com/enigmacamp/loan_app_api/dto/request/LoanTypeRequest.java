package com.enigmacamp.loan_app_api.dto.request;

import com.enigmacamp.loan_app_api.dto.response.LoanTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LoanTypeRequest {
    private String type;
    private Long maxLoan;
}
