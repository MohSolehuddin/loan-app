package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathApi.TRANSACTION)
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
//
//    @GetMapping
//    public ResponseEntity<?> getAllTransaction() {
//        return null;
//    }
//
//    @GetMapping
//    public ResponseEntity<?> getTransactionById() {
//        return null;
//    }

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody String id) {
        return null;
    }
}
