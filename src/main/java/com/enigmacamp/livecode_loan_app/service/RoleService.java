package com.enigmacamp.livecode_loan_app.service;

import com.enigmacamp.livecode_loan_app.entity.Role;

public interface RoleService {
    Role getOrSave(Role role);
}
