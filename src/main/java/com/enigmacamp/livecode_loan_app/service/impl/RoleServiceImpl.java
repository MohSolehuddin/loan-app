package com.enigmacamp.livecode_loan_app.service.impl;

import com.enigmacamp.livecode_loan_app.entity.Role;
import com.enigmacamp.livecode_loan_app.repository.RoleRepository;
import com.enigmacamp.livecode_loan_app.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getOrSave(Role role) {
        Optional<Role> optionalRole = roleRepository.findByRole(role.getRole());

        if (!optionalRole.isEmpty()){
            return optionalRole.get();
        }

        return roleRepository.save(role);
    }
}
