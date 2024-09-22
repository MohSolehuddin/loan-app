package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.repository.UserRepository;
import com.enigmacamp.loan_app_api.repository.UserRoleRepository;
import com.enigmacamp.loan_app_api.security.JwtUtil;
import com.enigmacamp.loan_app_api.service.AuthService;
import com.enigmacamp.loan_app_api.service.RoleService;
import com.enigmacamp.loan_app_api.util.ValidationUtil;
import com.enigmacamp.loan_app_api.constant.ERole;
import com.enigmacamp.loan_app_api.dto.request.AuthRequest;
import com.enigmacamp.loan_app_api.dto.response.LoginResponse;
import com.enigmacamp.loan_app_api.dto.response.RegisterResponse;
import com.enigmacamp.loan_app_api.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CustomerServiceImpl customerService;
    private final RoleService roleService;
    private final JwtUtil jwtUtil;
    private final ValidationUtil validationUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRoleRepository userRoleRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RegisterResponse signup(AuthRequest request) {
        try {
            validationUtil.validate(request);
            //role
            Role roleStaff = roleService.getOrSave(Role.builder()
                    .role(ERole.ROLE_STAFF)
                    .build());

            Role roleAdmin = roleService.getOrSave(Role.builder()
                    .role(ERole.ROLE_ADMIN)
                    .build());
            // user credential
            User userCredential = User.builder()
                    .email(request.getEmail().toLowerCase())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();
            userRepository.saveAndFlush(userCredential);

            //customer
            Customer customer = Customer.builder()
                    .user(userCredential)
                    .build();
            customerService.createCustomer(customer);

            List<String> roles = Arrays.asList(roleStaff.getRole().toString(), roleAdmin.getRole().toString());
            return RegisterResponse.builder()
                    .email(userCredential.getEmail())
                    .roles(roles)
                    .build();

        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
    }

    @Override
    public LoginResponse signin(AuthRequest request) {
        // tempat untuk logic login
        validationUtil.validate(request);
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail().toLowerCase(),
                request.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authenticate);

        // object AppUser
        AppUser appUser = (AppUser) authenticate.getPrincipal();
        String token = jwtUtil.generateToken(appUser);

        return LoginResponse.builder()
                .email(appUser.getEmail())
                .token(token)
                .role(appUser.getRoles().toString())
                .build();
    }
}