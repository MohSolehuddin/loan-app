package com.enigmacamp.livecode_loan_app.mapper;

import com.enigmacamp.livecode_loan_app.dto.request.AuthRequest;
import com.enigmacamp.livecode_loan_app.dto.response.LoginResponse;
import com.enigmacamp.livecode_loan_app.dto.response.RegisterResponse;
import com.enigmacamp.livecode_loan_app.entity.AppUser;

public class AuthMapper {
    public static LoginResponse mapToLoginResponse(AppUser appUser){
        return LoginResponse.builder()
                .email(appUser.getEmail())
                .role(appUser.getRoles().toString())
                .build();
    }
    public static RegisterResponse mapToRegisterResponse(AuthRequest request){
        return null;
    }
}
