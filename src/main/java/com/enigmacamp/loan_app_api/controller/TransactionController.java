package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.dto.request.ApproveLoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionPayRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.entity.LoanTransaction;
import com.enigmacamp.loan_app_api.service.LoanTransactionService;
import com.enigmacamp.loan_app_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping(PathApi.TRANSACTION)
@RequiredArgsConstructor
public class TransactionController {
    private final LoanTransactionService loanTransactionService;

    @GetMapping
    public ResponseEntity<?> getAllTransaction() {
        return null;
    }

    @GetMapping(PathApi.PATH_VAR_ID)
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        LoanTransactionResponse loanTransactionResponse = loanTransactionService.findLoanTransactionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(loanTransactionResponse);
    }

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody LoanTransactionRequest request) {
        LoanTransactionResponse loanTransactionResponse = loanTransactionService.createLoanTransactionCustomerOnly(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanTransactionResponse);
    }

    @PutMapping(PathApi.PAY)
    public ResponseEntity<?> payLoanTransaction(@PathVariable String trxId, @RequestBody LoanTransactionPayRequest request){
        LoanTransactionResponse loanTransactionResponse = loanTransactionService.payLoanTransaction(trxId, request);
        return ResponseEntity.status(HttpStatus.OK).body(loanTransactionResponse);
    }

    @PutMapping(PathApi.APPROVE)
    public ResponseEntity<?> approveLoanTransaction(@PathVariable String adminId, ApproveLoanTransactionRequest request){
        LoanTransactionResponse loanTransactionResponse = loanTransactionService.approveLoanTransactionAdminOnly(adminId ,request);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
