package com.nixtortech.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nixtortech.entity.EmployeeEntity;
import com.nixtortech.service.EmployeeService;

/**
 * 
 * @author AJIT KUMAR
 * @since 1.0
 *
 */

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	/**
	 * 
	 * @param employeeEntity
	 * @return Saved Employee Entity
	 */

	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<?> registerEmployee(@RequestBody EmployeeEntity employeeEntity) {
		logger.debug("Register Employee Method Is Started");
		ResponseEntity<?> response = null;
		try {
			EmployeeEntity saveEmployee = employeeService.saveEmployee(employeeEntity);
			if (saveEmployee.getEmployeeId() != null) {
				response = new ResponseEntity<String>("Hey " + saveEmployee.getEmployeeName()
						+ " Your Registration Is Successfully Completed You Can Verify Your Details Below \n"
						+ saveEmployee, HttpStatus.CREATED);
				logger.debug("Employee Registartion Is Successfully Completed !");
			} else {
				response = new ResponseEntity<String>(
						"Hey " + saveEmployee.getEmployeeName() + "Your Registration Is Failed",
						HttpStatus.INTERNAL_SERVER_ERROR);
				logger.debug("Employee registration is failed "+employeeEntity.getEmployeeName());
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Some Technical Probleam Occured ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.debug("Register Employee Method Is Started");
		return response;

	}

	/**
	 * 
	 * @param employeeEntity
	 * @return Updated Employee Entity
	 */

	@PostMapping(value = "/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
		ResponseEntity<?> response = null;
		try {
			EmployeeEntity saveEmployee = employeeService.saveEmployee(employeeEntity);
			if (saveEmployee.getEmployeeId() != null) {
				response = new ResponseEntity<String>("Hey " + saveEmployee.getEmployeeName()
						+ " Your Details Is Updated Successfully Completed You Can Verify Your Details Below \n"
						+ saveEmployee, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity<String>(
						"Hey " + saveEmployee.getEmployeeName() + "Your Details Is Updation Is Failed",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Some Technical Probleam Occured ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	/**
	 * 
	 * @return
	 */

	@GetMapping(value = "employees")
	public ResponseEntity<?> getAllEmployee() {
		ResponseEntity<?> response = null;
		logger.debug("getAllEmployee Method Is Started !!");
		try {
			List<EmployeeEntity> allEmployee = employeeService.findAllEmployee();
			if (allEmployee.isEmpty()) {
				response = new ResponseEntity<String>("Employee Data Is Not Available", HttpStatus.NO_CONTENT);
				logger.debug("Employee Data Is Not Available !!");
			} else {
				response = new ResponseEntity<List<EmployeeEntity>>(allEmployee, HttpStatus.OK);
				logger.debug(" Employee Data Is Successfully Fatched");
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Some Technical Exception is Occured",
					HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Some Technical Exception Is Occured !!");
		}
		logger.debug("getAllEmployee Method is Ended");
		return response;
	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 */

	@GetMapping(value = "/employeeId/{employeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId) {
		logger.info("getEmployeeById Method Execution is Started");
		ResponseEntity<?> response = null;

		try {
			EmployeeEntity employeeById = employeeService.findEmployeeById(employeeId);
			if (employeeById != null) {
				response = new ResponseEntity<EmployeeEntity>(employeeById, HttpStatus.OK);
				logger.debug("Employee Data Is Fatched");
			} else {

				response = new ResponseEntity<String>("Employee Not Found With Given Id +" + employeeId,
						HttpStatus.NOT_FOUND);
				logger.debug(" Employee Not Exist With Given Id");

			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Some Technical Exception is Occured",
					HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Some Technical Exception Occured");
		}

		logger.info("Method Execution completed");
		return response;
	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 */

	@DeleteMapping(value = "/deleteByid/{employeeId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer employeeId) {
		
		logger.info("deleteEmployeeById Method Execution is Started !!");
		
		ResponseEntity<?> response = null;

		try {
			Boolean isEmployeeDeleted = employeeService.deleteEmployeeById(employeeId);
			if (isEmployeeDeleted) {
				response = new ResponseEntity<String>(
						" Your Account is Successfully Deleted With given Id " + employeeId, HttpStatus.OK);
				logger.info("Employee Account is deleted");
			} else {
				response = new ResponseEntity<String>("Some Probleam Is Occured Try After Some time",
						HttpStatus.CONTINUE);
				logger.debug("Some Probleam is Occured");
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>("Some Technical Exception is Occured",
					HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Some Technical Exception is Occured");
		}

		logger.info("Method Execution is successfully completed");
		return response;
	}

}
