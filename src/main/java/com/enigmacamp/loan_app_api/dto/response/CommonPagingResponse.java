package com.enigmacamp.loan_app_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CommonPagingResponse<T> {
    private String message;
    private Integer statusCode;
    private T data;
    private Object paging;
}
