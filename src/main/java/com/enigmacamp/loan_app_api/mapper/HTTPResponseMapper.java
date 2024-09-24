package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.CommonPagingResponse;
import com.enigmacamp.loan_app_api.dto.response.CommonResponse;
import com.enigmacamp.loan_app_api.dto.response.PagingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public static ResponseEntity<CommonPagingResponse<Object>> pagingResponse(Page<?> pageResponse, HttpStatus status, String message){
        PagingResponse response = PagingResponse.builder()
                .page(pageResponse.getTotalPages())
                .size(pageResponse.getSize())
                .count((long) pageResponse.getTotalPages())
                .totalPages(pageResponse.getTotalPages())
                .build();
        return ResponseEntity.status(status).body(CommonPagingResponse.builder()
                        .statusCode(status.value())
                        .message("Successfully get data in page " + pageResponse.getTotalPages())
                        .data(pageResponse.getContent())
                .paging(response).build());
    }
}
