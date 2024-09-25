package com.enigmacamp.loan_app_api.entity;

import com.enigmacamp.loan_app_api.constant.EInstalmentType;
import com.enigmacamp.loan_app_api.constant.PathDb;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = PathDb.INSTALMENT_TYPE)
public class InstalmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "instalment_type")
    @Enumerated(EnumType.STRING)
    private EInstalmentType instalmentType;
}