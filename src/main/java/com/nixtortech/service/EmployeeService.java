package com.nixtortech.service;

import java.util.List;

import com.nixtortech.entity.EmployeeEntity;

/**
 * 
 * @author AJIT KUMAR
 * @since 1.0
 *
 */

public interface EmployeeService {

	
	public List<EmployeeEntity> findAllEmployee();
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
	public EmployeeEntity findEmployeeById(Integer employeeId);
	public Boolean deleteEmployeeById(Integer employeeId);
	
}
