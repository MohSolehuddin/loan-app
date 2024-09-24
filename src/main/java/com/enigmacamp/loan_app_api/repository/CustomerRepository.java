package com.enigmacamp.loan_app_api.repository;

import com.enigmacamp.loan_app_api.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String > {
    Page<Customer> findAllByDeletedAt(String deletedAt, Pageable pageable);
}
