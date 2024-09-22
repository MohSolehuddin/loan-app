package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.entity.Role;
import com.enigmacamp.loan_app_api.repository.RoleRepository;
import com.enigmacamp.loan_app_api.service.RoleService;
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
