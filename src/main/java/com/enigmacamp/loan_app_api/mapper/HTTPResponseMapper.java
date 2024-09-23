package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.CommonPagingResponse;
import com.enigmacamp.loan_app_api.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HTTPResponseMapper {
    public static ResponseEntity<CommonResponse<Object>> response(Object object, HttpStatus status, String message){
        CommonResponse<Object> commonResponse = CommonResponse.builder()
                .message(message)
                .statusCode(status.value())
                .data(object)
                .build();
        return ResponseEntity.status(status).body(commonResponse);
    }
    public static ResponseEntity<CommonPagingResponse<Object>> pagingResponse(Object data, HttpStatus status){
        return null;
    }
}
