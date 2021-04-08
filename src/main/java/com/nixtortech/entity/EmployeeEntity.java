/*
 * Copyright All Rights Are Reserved 2020 - 2021
 */
package com.nixtortech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author AJIT KUMAR
 * @since 1.0
 * @category Entity Class
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "EMP_CURD_APP")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "EMPLOYEE_MOB_NO")
	private String employeeMobNo;
	@Column(name = "EMPLOYEE_ADDRESS")
	private String employeeAddress;
	

}
