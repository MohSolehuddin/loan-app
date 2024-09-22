package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.response.LoginResponse;
import com.enigmacamp.loan_app_api.dto.response.RegisterResponse;
import com.enigmacamp.loan_app_api.dto.request.AuthRequest;

public interface AuthService {
    RegisterResponse signup(AuthRequest register);
    LoginResponse signin(AuthRequest login);
}