package com.enigmacamp.loan_app_api.service.impl;

import com.enigmacamp.loan_app_api.constant.EInstalmentType;
import com.enigmacamp.loan_app_api.dto.request.InstalmentTypeRequest;
import com.enigmacamp.loan_app_api.dto.request.InstalmentTypeUpdateRequest;
import com.enigmacamp.loan_app_api.dto.response.InstalmentTypeResponse;
import com.enigmacamp.loan_app_api.entity.InstalmentType;
import com.enigmacamp.loan_app_api.mapper.InstalmentTypeMapper;
import com.enigmacamp.loan_app_api.repository.InstalmentTypeRepository;
import com.enigmacamp.loan_app_api.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstalmentTypeServiceImpl implements InstalmentTypeService {
    private final InstalmentTypeRepository instalmentTypeRepository;

    @Override
    public InstalmentTypeResponse createInstalmentType(InstalmentTypeRequest instalmentTypeRequest) {
        Optional<InstalmentType> instalmentTypeOptional = instalmentTypeRepository.findByInstalmentType(EInstalmentType.valueOf(instalmentTypeRequest.getInstalmentType()));
        if (instalmentTypeOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Sorry don't creating instalment type because instalment type already exist");
        }
        InstalmentType newInstalmentType = InstalmentType.builder()
                .instalmentType(EInstalmentType.valueOf(instalmentTypeRequest.getInstalmentType()))
                .build();
        instalmentTypeRepository.save(newInstalmentType);
        return InstalmentTypeMapper.mapToInstalmentTypeResponse(newInstalmentType);
    }

    @Override
    public InstalmentTypeResponse updateInstalmentType(InstalmentTypeUpdateRequest updateRequest) {
        InstalmentType findInstalmentType = findInstalmentTypeOrThrowNotFound(updateRequest.getId());
        try {
            findInstalmentType.setInstalmentType(EInstalmentType.valueOf(updateRequest.getInstalmentType()));
            instalmentTypeRepository.save(findInstalmentType);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, Instalment type not ready in list");
        }
        return InstalmentTypeMapper.mapToInstalmentTypeResponse(findInstalmentType);
    }

    @Override
    public InstalmentTypeResponse getInstalmentTypeById(String id) {
        InstalmentType instalmentType = findInstalmentTypeOrThrowNotFound(id);
        return InstalmentTypeMapper.mapToInstalmentTypeResponse(instalmentType);
    }

    @Override
    public Page<InstalmentTypeResponse> getAllInstalmentType(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<InstalmentType> instalmentTypePage = instalmentTypeRepository.findAll(pageable);
        if (instalmentTypePage.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Instalment not found");
        }
        return instalmentTypePage.map(InstalmentTypeMapper::mapToInstalmentTypeResponse);
    }

    @Override
    public void deleteInstalmentType(String id) {
        InstalmentType findInstalmentType = findInstalmentTypeOrThrowNotFound(id);
        instalmentTypeRepository.delete(findInstalmentType);
    }

    private InstalmentType findInstalmentTypeOrThrowNotFound(String id) {
        Optional<InstalmentType> instalmentType = instalmentTypeRepository.findById(id);
        return instalmentType.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }
}