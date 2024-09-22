package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.dto.request.AuthRequest;
import com.enigmacamp.loan_app_api.dto.response.CommonResponse;
import com.enigmacamp.loan_app_api.dto.response.LoginResponse;
import com.enigmacamp.loan_app_api.dto.response.RegisterResponse;
import com.enigmacamp.loan_app_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathApi.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(PathApi.SIGN_UP)
    public ResponseEntity<?> register(@RequestBody AuthRequest request){
        RegisterResponse registerResponse = authService.signup(request);
        CommonResponse<RegisterResponse> response = CommonResponse.<RegisterResponse>builder()
                .message("Successfully created customer")
                .statusCode(HttpStatus.CREATED.value())
                .data(registerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(PathApi.SIGN_IN)
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        LoginResponse login = authService.signin(request);
        CommonResponse<LoginResponse> response = CommonResponse.<LoginResponse>builder()
                .message("successfully login")
                .statusCode(HttpStatus.OK.value())
                .data(login)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}