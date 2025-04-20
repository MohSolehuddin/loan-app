package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.constant.ApprovalStatus;
import com.enigmacamp.loan_app_api.constant.LoanStatus;
import com.enigmacamp.loan_app_api.dto.request.ApproveLoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionPayRequest;
import com.enigmacamp.loan_app_api.dto.request.LoanTransactionRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTransactionResponse;
import com.enigmacamp.loan_app_api.entity.*;
import com.enigmacamp.loan_app_api.mapper.LoanTransactionMapper;
import com.enigmacamp.loan_app_api.repository.LoanTransactionDetailRepository;
import com.enigmacamp.loan_app_api.repository.LoanTransactionRepository;
import com.enigmacamp.loan_app_api.service.CustomerService;
import com.enigmacamp.loan_app_api.service.InstalmentTypeService;
import com.enigmacamp.loan_app_api.service.LoanTransactionService;
import com.enigmacamp.loan_app_api.service.LoanTypeService;
import com.enigmacamp.loan_app_api.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanTransactionServiceImpl implements LoanTransactionService {
    private final LoanTypeService loanTypeService;
    private final CustomerService customerService;
    private final InstalmentTypeService instalmentTypeService;
    private final LoanTransactionRepository loanTransactionRepository;
    private final LoanTransactionDetailRepository loanTransactionDetailRepository;
    private final ValidationUtil validationUtil;

    @Override
    public LoanTransactionResponse createLoanTransactionCustomerOnly(LoanTransactionRequest request) {
        try {
            validationUtil.validate(request);
            LoanType loanType = loanTypeService.findOrThrowNotFound(request.getLoanTypeId());

            if (loanType.getMaxLoan() < request.getNominal()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nominal loan grether than max loan");
            }
            Customer customer = customerService.findCustomerOrThrowNotFound(request.getCustomerId());
            InstalmentType instalmentType = instalmentTypeService.findInstalmentTypeOrThrowNotFound(request.getInstalmentTypeId());

            LoanTransaction loanTransaction = LoanTransaction.builder()
                    .loanType(loanType)
                    .customer(customer)
                    .createdAt(LocalDateTime.now())
                    .approvalStatus(ApprovalStatus.PENDING)
                    .instalmentType(instalmentType)
                    .nominal(request.getNominal())
                    .build();

            loanTransactionRepository.saveAndFlush(loanTransaction);
            return LoanTransactionMapper.mapToResponse(loanTransaction);
        } catch (ResponseStatusException e){
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error" );
        }

    }

    @Override
    public LoanTransactionResponse approveLoanTransactionAdminOnly(String adminId, ApproveLoanTransactionRequest request) {
        try {
            validationUtil.validate(request);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AppUser user = (AppUser) authentication.getPrincipal();

            if (!Objects.equals(user.getId(), adminId)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Admin id is not same and request from another user");
            }

            LoanTransaction loanTransaction = findOrThrowNotFound(request.getLoanTransactionId());
            loanTransaction.setApprovedBy(adminId);
            loanTransaction.setApprovedAt(LocalDateTime.from(Instant.now()));
            LoanTransaction loanTransactionUpdate = loanTransactionRepository.saveAndFlush(loanTransaction);

            return LoanTransactionMapper.mapToResponse(loanTransactionUpdate);
        }catch (ResponseStatusException e){
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        }

    }

    @Override
    public LoanTransactionResponse findLoanTransactionById(String id) {
        LoanTransaction loanTransaction = findOrThrowNotFound(id);
        try {
            return LoanTransactionMapper.mapToResponse(loanTransaction);
        }catch (Exception e) {
            System.out.println(id);
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    @Override
    public LoanTransactionResponse payLoanTransaction(String id, LoanTransactionPayRequest request) {
        LoanTransaction loanTransaction = findOrThrowNotFound(id);

        LoanTransactionDetail loanTransactionDetail = loanTransactionDetailRepository.saveAndFlush(
                LoanTransactionDetail.builder()
                        .loanStatus(LoanStatus.PAID)
                        .loanTransaction(loanTransaction)
                        .transactionDate(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .nominal(request.getNominal())
                        .build()
        );
        loanTransaction.getLoanTransactionDetails().add(loanTransactionDetail);

        LoanTransaction loanTransactionUpdated = loanTransactionRepository.save(loanTransaction);
        return LoanTransactionMapper.mapToResponse(loanTransactionUpdated);
    }

    public LoanTransaction findOrThrowNotFound(String id) {
        Optional<LoanTransaction> loanTransaction = loanTransactionRepository.findById(id);
        return loanTransaction.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan transaction not found"));
    }
}