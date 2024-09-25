package com.enigmacamp.loan_app_api.service;

import com.enigmacamp.loan_app_api.dto.request.InstalmentTypeRequest;
import com.enigmacamp.loan_app_api.dto.request.InstalmentTypeUpdateRequest;
import com.enigmacamp.loan_app_api.dto.response.InstalmentTypeResponse;
import com.enigmacamp.loan_app_api.entity.Customer;
import com.enigmacamp.loan_app_api.entity.InstalmentType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InstalmentTypeService {
    InstalmentTypeResponse createInstalmentType(InstalmentTypeRequest instalmentTypeRequest);
    InstalmentTypeResponse updateInstalmentType(InstalmentTypeUpdateRequest updateRequest);
    InstalmentTypeResponse getInstalmentTypeById(String id);
    Page<InstalmentTypeResponse> getAllInstalmentType(Integer page, Integer size);
    void deleteInstalmentType(String id);
}