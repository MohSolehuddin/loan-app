package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.request.ApproveLoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionPayRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import org.springframework.web.server.ResponseStatusException;

public interface LoanTransactionService {
    LoanTransactionResponse createLoanTransactionCustomerOnly(LoanTransactionRequest request);
    LoanTransactionResponse approveLoanTransactionAdminOnly(String adminId, ApproveLoanTransactionRequest request);
    LoanTransactionResponse findLoanTransactionById(String id);
    LoanTransactionResponse payLoanTransaction(String id, LoanTransactionPayRequest request);
}