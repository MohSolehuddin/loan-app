package com.enigmacamp.livecode_loan_app.repository;

import com.enigmacamp.livecode_loan_app.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
