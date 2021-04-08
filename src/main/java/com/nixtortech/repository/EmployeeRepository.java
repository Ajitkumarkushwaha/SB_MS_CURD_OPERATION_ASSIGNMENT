package com.nixtortech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nixtortech.entity.EmployeeEntity;

/**
 * 
 * @author AJIT KUMAR
 * @since 1.0
 *
 */

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
