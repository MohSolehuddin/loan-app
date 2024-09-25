package com.enigmacamp.loan_app_api.mapper;

import com.enigmacamp.loan_app_api.dto.response.InstalmentTypeResponse;
import com.enigmacamp.loan_app_api.entity.InstalmentType;

public class InstalmentTypeMapper {
    public static InstalmentTypeResponse mapToInstalmentTypeResponse(InstalmentType instalmentType){
        return InstalmentTypeResponse.builder()
                .id(instalmentType.getId())
                .instalmentType(String.valueOf(instalmentType.getInstalmentType()))
                .build();
    }
}