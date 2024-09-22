package com.enigmacamp.loan_app_api.dto.response;

public class CommonPagingResponse<T> {
    private String message;
    private Integer statusCode;
    private T data;
    private Object paging;
}
