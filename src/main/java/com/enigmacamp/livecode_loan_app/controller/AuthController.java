package com.enigmacamp.livecode_loan_app.controller;

import com.enigmacamp.livecode_loan_app.constant.PathApi;
import com.enigmacamp.livecode_loan_app.dto.request.AuthRequest;
import com.enigmacamp.livecode_loan_app.dto.response.CommonResponse;
import com.enigmacamp.livecode_loan_app.dto.response.LoginResponse;
import com.enigmacamp.livecode_loan_app.dto.response.RegisterResponse;
import com.enigmacamp.livecode_loan_app.service.AuthService;
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