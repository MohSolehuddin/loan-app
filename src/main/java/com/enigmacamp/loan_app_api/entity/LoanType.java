package com.enigmacamp.loan_app_api.entity;

import com.enigmacamp.loan_app_api.constant.PathDb;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = PathDb.LOAN_TYPE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String type;
    @Column(name = "max_loan")
    private Double maxLoan;
}