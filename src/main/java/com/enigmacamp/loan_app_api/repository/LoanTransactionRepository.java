package com.enigmacamp.loan_app_api.repository;

import com.enigmacamp.loan_app_api.entity.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, String > {
}
