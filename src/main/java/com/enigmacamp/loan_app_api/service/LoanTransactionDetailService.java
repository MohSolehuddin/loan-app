package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.request.LoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.entity.LoanTransaction;
import com.enigmacamp.loan_app_api.entity.LoanTransactionDetail;

public interface LoanTransactionDetailService {
    LoanTransactionDetail createLoanTransaction(LoanTransactionDetail loanTransactionDetail);
    LoanTransactionDetail getAllLoanTransaction();
    LoanTransactionDetail getLoanTransactionById(String id);
    LoanTransactionDetail updateLoanTransaction(LoanTransactionDetail loanTransactionDetail);
    void deleteLoanTransaction(String id);
}