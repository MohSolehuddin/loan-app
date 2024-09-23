package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.entity.UserRole;
import com.enigmacamp.loan_app_api.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Override
    public Optional<UserRole> getRoleByUserId(String userId) {
        return Optional.empty();
    }
}
