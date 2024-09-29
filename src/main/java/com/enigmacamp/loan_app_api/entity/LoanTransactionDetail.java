package com.enigmacamp.loan_app_api.entity;

import com.enigmacamp.loan_app_api.constant.LoanStatus;
import com.enigmacamp.loan_app_api.constant.PathDb;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = PathDb.LOAN_TRANSACTION_DETAIL)
public class LoanTransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column
    private Double nominal;

    @ManyToOne
    @JoinColumn(name = "loan_transaction_id")
    @JsonBackReference
    private LoanTransaction loanTransaction;

    @ManyToOne
    @JoinColumn(name = "guarantee_picture")
    private GuaranteePicture guaranteePicture;

    @Column(name = "loan_status")
    private LoanStatus loanStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}