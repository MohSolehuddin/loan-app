package com.enigmacamp.livecode_loan_app.dto.response;

import com.enigmacamp.livecode_loan_app.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private String email;
    private List<String> roles;
}