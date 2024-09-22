package com.enigmacamp.loan_app_api.entity;

import com.enigmacamp.loan_app_api.constant.ERole;
import com.enigmacamp.loan_app_api.constant.PathDb;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PathDb.ROLE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    @Enumerated(EnumType.STRING)
    private ERole role;
}