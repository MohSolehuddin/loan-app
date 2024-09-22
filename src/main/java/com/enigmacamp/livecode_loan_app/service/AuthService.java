package com.enigmacamp.livecode_loan_app.service;

import com.enigmacamp.livecode_loan_app.dto.response.LoginResponse;
import com.enigmacamp.livecode_loan_app.dto.response.RegisterResponse;
import com.enigmacamp.livecode_loan_app.dto.request.AuthRequest;

public interface AuthService {
    RegisterResponse signup(AuthRequest register);
    LoginResponse signin(AuthRequest login);
}