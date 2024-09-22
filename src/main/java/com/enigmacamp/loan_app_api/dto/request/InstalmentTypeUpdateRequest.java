package com.enigmacamp.loan_app_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class InstalmentTypeUpdateRequest {
    private String id;
    private String instalmentType;
}