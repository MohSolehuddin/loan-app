package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.request.ApproveLoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.entity.LoanType;

public interface LoanTransactionService {
    LoanTransactionResponse createLoanTransactionCustomerOnly(LoanTransactionRequest request);
    LoanTransactionResponse approveLoanTransactionAdminOnly(ApproveLoanTransactionRequest approveLoanTransactionRequest);
    LoanTransactionResponse findLoanTransactionById(String id);
    LoanTransactionResponse payLoanTransaction(String id);
}