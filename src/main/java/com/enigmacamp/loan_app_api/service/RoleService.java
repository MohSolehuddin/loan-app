package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.entity.Role;

public interface RoleService {
    Role getOrSave(Role role);
}
