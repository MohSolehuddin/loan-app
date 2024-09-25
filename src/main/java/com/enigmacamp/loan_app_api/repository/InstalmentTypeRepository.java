package com.enigmacamp.loan_app_api.repository;

import com.enigmacamp.loan_app_api.constant.EInstalmentType;
import com.enigmacamp.loan_app_api.entity.InstalmentType;
import org.hibernate.query.sqm.IntervalType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String > {
    Optional<InstalmentType> findByInstalmentType(EInstalmentType instalmentType);
}
