package com.enigmacamp.livecode_loan_app.entity;

import com.enigmacamp.livecode_loan_app.constant.PathDb;
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
@Table(name = PathDb.LOAN_DOCUMENT)
public class LoanDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "content_type")
    private String contentType;

    @Column
    private String name;

    @Column
    private String path;

    @Column
    private long size;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
