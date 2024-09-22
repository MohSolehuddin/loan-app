package com.enigmacamp.loan_app_api.repository;

import com.enigmacamp.loan_app_api.entity.InstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String > {
}
