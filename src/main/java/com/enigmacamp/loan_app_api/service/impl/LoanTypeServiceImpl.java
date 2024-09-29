package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.dto.request.LoanTypeRequest;
import com.enigmacamp.loan_app_api.dto.response.LoanTypeResponse;
import com.enigmacamp.loan_app_api.entity.LoanType;
import com.enigmacamp.loan_app_api.mapper.LoanTypeMapper;
import com.enigmacamp.loan_app_api.repository.LoanTypeRepository;
import com.enigmacamp.loan_app_api.service.LoanTypeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoanTypeServiceImpl implements LoanTypeService {
    private final LoanTypeRepository loanTypeRepository;

    @Override
    public LoanTypeResponse createLoanType(LoanTypeRequest request) {
        LoanType loanType = LoanType.builder()
                .type(request.getType())
                .maxLoan(request.getMaxLoan())
                .build();
        loanTypeRepository.save(loanType);
        return LoanTypeMapper.mapToLoanTypeResponse(loanType);
    }

    @Override
    public LoanTypeResponse getLoanTypeById(String id) {
        LoanType loanType = findOrThrowNotFound(id);
        return LoanTypeMapper.mapToLoanTypeResponse(loanType);
    }

    @Override
    public Page<LoanTypeResponse> getAllLoanType(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<LoanType> loanTypeResponsePage = loanTypeRepository.findAll(pageable);
        if (loanTypeResponsePage.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry data loan is not found");
        }
        return loanTypeResponsePage.map(LoanTypeMapper::mapToLoanTypeResponse);
    }

    @Override
    public LoanTypeResponse updateLoanType(LoanType request) {
        LoanType findLoanType = findOrThrowNotFound(request.getId());
        if (request.getType() != null){
            findLoanType.setType(request.getType());
        }
        if (request.getMaxLoan() != null){
            findLoanType.setMaxLoan(request.getMaxLoan());
        }
        return LoanTypeMapper.mapToLoanTypeResponse(loanTypeRepository.save(findLoanType));
    }

    @Override
    public void deleteLoanType(String id) {
        LoanType findLoanType = findOrThrowNotFound(id);
        loanTypeRepository.delete(findLoanType);
    }
    @Override
    public LoanType findOrThrowNotFound(String id){
        return loanTypeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, Loan type is not found"));
    }
}
