package com.enigmacamp.loan_app_api.controller;

import com.enigmacamp.loan_app_api.constant.PathApi;
import com.enigmacamp.loan_app_api.constant.UserLevel;
import com.enigmacamp.loan_app_api.dto.request.InstalmentTypeRequest;
import com.enigmacamp.loan_app_api.dto.request.InstalmentTypeUpdateRequest;
import com.enigmacamp.loan_app_api.dto.response.InstalmentTypeResponse;
import com.enigmacamp.loan_app_api.mapper.HTTPResponseMapper;
import com.enigmacamp.loan_app_api.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathApi.IMPLEMENT_TYPE)
//@PreAuthorize(UserLevel.ADMIN_AND_STAFF)
@RequiredArgsConstructor
public class InstalmentTypeController {
    private final InstalmentTypeService instalmentTypeService;

    @GetMapping
    public ResponseEntity<?> getAllInstalmentType(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "5") Integer size){
        Page<InstalmentTypeResponse> response = instalmentTypeService.getAllInstalmentType(page, size);
        return HTTPResponseMapper.pagingResponse(response, HttpStatus.OK, "Successfully get all data instalment type");
    }

    @GetMapping(PathApi.PATH_VAR_ID)
    public ResponseEntity<?> getInstalmentTypeById(@PathVariable String id){
        InstalmentTypeResponse response = instalmentTypeService.getInstalmentTypeById(id);
        return HTTPResponseMapper.response(response, HttpStatus.OK, "Successfully get data instalment by id");
    }

    @PutMapping
    public ResponseEntity<?> updateInstalmentType(@RequestBody InstalmentTypeUpdateRequest request){
        InstalmentTypeResponse response = instalmentTypeService.updateInstalmentType(request);
        return HTTPResponseMapper.response(response, HttpStatus.CREATED, "successfully update data instalment type");
    }

    @DeleteMapping(PathApi.PATH_VAR_ID)
    public ResponseEntity<?> deleteInstalmentType(@PathVariable String id){
        instalmentTypeService.deleteInstalmentType(id);
        return HTTPResponseMapper.response(null, HttpStatus.OK, "Successfully deleting data instalment type");
    }

    @PostMapping
    public ResponseEntity<?> createInstalmentType(@RequestBody InstalmentTypeRequest request){
        InstalmentTypeResponse response = instalmentTypeService.createInstalmentType(request);
        return HTTPResponseMapper.response(response, HttpStatus.CREATED, "Successfully creating instalment type");
    }
}
