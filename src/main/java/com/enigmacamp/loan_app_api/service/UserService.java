package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AppUser loadUserByUserId(String id);
}
