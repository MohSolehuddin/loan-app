package com.enigmacamp.loan_app_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CustomerRequest {
        private String id;
        @NotBlank(message = "First name is required")
        private String firstName;
        @NotBlank(message = "Last name is required")
        private String lastName;
        private Date dateOfBirth;
        private String phone;
        private String status;
}
