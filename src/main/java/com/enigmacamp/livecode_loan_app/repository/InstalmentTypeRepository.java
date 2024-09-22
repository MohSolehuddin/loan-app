package com.enigmacamp.livecode_loan_app.repository;

import com.enigmacamp.livecode_loan_app.entity.InstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String > {
}
