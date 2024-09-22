package com.enigmacamp.loan_app_api.repository;

import com.enigmacamp.loan_app_api.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String > {
}