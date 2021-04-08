package com.nixtortech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nixtortech.entity.EmployeeEntity;
import com.nixtortech.repository.EmployeeRepository;

/**
 * 
 * @author AJIT KUMAR
 * @since 1.0
 *
 */

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeEntity> findAllEmployee() {
		List<EmployeeEntity> AllEmployee = employeeRepository.findAll();
		if(AllEmployee.isEmpty()) {
			return null;
		}
		else {
			return AllEmployee;
		}
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
		EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
		return savedEmployee;
	}

	@Override
	public EmployeeEntity findEmployeeById(Integer employeeId) {
		Optional<EmployeeEntity> employeeById = employeeRepository.findById(employeeId);
		if(employeeById.isPresent()) {
		return	employeeById.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Boolean deleteEmployeeById(Integer employeeId) {
		Optional<EmployeeEntity> employeeExist = employeeRepository.findById(employeeId);
		if(employeeExist.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return true;
		}
		else {
			return false;
		}
	}

}
