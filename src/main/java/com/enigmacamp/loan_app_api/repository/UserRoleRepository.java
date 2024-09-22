package com.enigmacamp.loan_app_api.repository;

import com.enigmacamp.loan_app_api.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
