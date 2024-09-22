package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.dto.response.CommonResponse;
import com.enigmacamp.loan_app_api.dto.response.UserResponse;
import com.enigmacamp.loan_app_api.entity.AppUser;
import com.enigmacamp.loan_app_api.service.UserService;
import com.enigmacamp.loan_app_api.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(PathApi.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ValidationUtil validationUtil;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        try{
            AppUser user = userService.loadUserByUserId(id);
            validationUtil.validate(user);
            UserResponse response = UserResponse.builder()
                    .email(user.getEmail())
                    .roles(user.getRoles().stream().map(role -> role.getRole().name().toLowerCase().substring(5)).toList())
                    .build();
            return ResponseEntity.status(200).body(
                    CommonResponse.builder()
                            .message("Successfully getting data user by id")
                            .statusCode(200)
                            .data(response)
                            .build());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " not found");
        }

    }
}
