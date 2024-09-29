package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.constant.ApprovalStatus;
import com.enigmacamp.loan_app_api.constant.LoanStatus;
import com.enigmacamp.loan_app_api.dto.request.ApproveLoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.dto.response.LoanTypeResponse;
import com.enigmacamp.loan_app_api.entity.Customer;
import com.enigmacamp.loan_app_api.entity.InstalmentType;
import com.enigmacamp.loan_app_api.entity.LoanTransaction;
import com.enigmacamp.loan_app_api.entity.LoanType;
import com.enigmacamp.loan_app_api.repository.LoanTypeRepository;
import com.enigmacamp.loan_app_api.service.CustomerService;
import com.enigmacamp.loan_app_api.service.InstalmentTypeService;
import com.enigmacamp.loan_app_api.service.LoanTransactionService;
import com.enigmacamp.loan_app_api.service.LoanTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanTransactionServiceImpl implements LoanTransactionService {
    private final LoanTypeService loanTypeService;
    private final CustomerService customerService;
    private final InstalmentTypeService instalmentTypeService;

    @Override
    public LoanTransactionResponse createLoanTransactionCustomerOnly(LoanTransactionRequest request) {
//        LoanType loanType = loanTypeService.findOrThrowNotFound(request.getLoanTypeId());
//        Customer customer = customerService.findCustomerOrThrowNotFound(request.getCustomerId());
//        InstalmentType instalmentType = instalmentTypeService.getInstalmentTypeBY(request.getInstalmentType());
//
//        LoanTransaction loanTransaction = LoanTransaction.builder()
//                .loanType(loanType)
//                .customer(customer)
//                .createdAt(LocalDateTime.now())
//                .approvalStatus(ApprovalStatus.PENDING)
//                .instalmentType(request.getInstalmentType())
//                .build();
        return null;
    }

    @Override
    public LoanTransactionResponse approveLoanTransactionAdminOnly(ApproveLoanTransactionRequest approveLoanTransactionRequest) {
        return null;
    }

    @Override
    public LoanTransactionResponse findLoanTransactionById(String id) {
        return null;
    }

    @Override
    public LoanTransactionResponse payLoanTransaction(String id) {
        return null;
    }
}