package com.enigmacamp.livecode_loan_app.service.impl;

import com.enigmacamp.livecode_loan_app.constant.ERole;
import com.enigmacamp.livecode_loan_app.entity.AppUser;
import com.enigmacamp.livecode_loan_app.entity.User;
import com.enigmacamp.livecode_loan_app.repository.UserRepository;
import com.enigmacamp.livecode_loan_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    // verifikasi JWT
    @Override
    public AppUser loadUserByUserId(String id) {
        User userCredential = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Invalid credential"));
        return AppUser.builder()
                .id(userCredential.getId())
                .email(userCredential.getEmail())
                .password(userCredential.getPassword())
                .roles(userCredential.getRoles().stream().map(role -> role.getRole()).toList())
                .build();
    }

    // verifikasi authentikasi login
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userCredential = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Invalid credential"));
        return AppUser.builder()
                .id(userCredential.getId())
                .email(userCredential.getEmail())
                .password(userCredential.getPassword())
                .roles(userCredential.getRoles().stream().map(role -> role.getRole()).toList())
                .build();
    }
}
