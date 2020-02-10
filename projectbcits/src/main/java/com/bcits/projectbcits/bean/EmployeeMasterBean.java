package com.bcits.projectbcits.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_master")
public class EmployeeMasterBean implements Serializable{
	@Id
	@Column(name = "employee_id")
	private int empId;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String region;
	
	@Column
	private long mobilenum;
	
}
