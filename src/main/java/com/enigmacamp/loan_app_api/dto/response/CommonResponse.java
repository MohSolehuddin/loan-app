package com.enigmacamp.loan_app_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse <T>{
    private String message;
    private Integer statusCode;
    private T data;
    private PagingResponse paging;
}