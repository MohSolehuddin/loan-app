package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.entity.Role;
import com.enigmacamp.loan_app_api.entity.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> getRoleByUserId(String userId);
}
