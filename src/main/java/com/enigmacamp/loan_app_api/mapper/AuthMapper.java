package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.request.AuthRequest;
import com.enigmacamp.loan_app_api.dto.response.LoginResponse;
import com.enigmacamp.loan_app_api.dto.response.RegisterResponse;
import com.enigmacamp.loan_app_api.entity.AppUser;

public class AuthMapper {
    public static LoginResponse mapToLoginResponse(AppUser appUser){
        return LoginResponse.builder()
                .email(appUser.getEmail())
                .role(appUser.getRoles().stream().map(role -> role.getRole().name()).toList())
                .build();
    }
    public static RegisterResponse mapToRegisterResponse(AuthRequest request){
        return null;
    }
}
