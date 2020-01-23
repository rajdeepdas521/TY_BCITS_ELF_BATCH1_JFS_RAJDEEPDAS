package com.bcits.springcoreannotations.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class EmployeeBean {

	private String name;
	private int age;
	@Autowired(required = false)
	@Qualifier("hr")
	private DepartmentBean departmentBean;
	
	/*
	 * @PostConstruct public void init() 
	 * { System.out.println("It init-phase!!!"); }
	 * 
	 * @PreDestroy public void destroy() {
	 * System.out.println("It destruction phase!!!"); }
	 */
	
}// End Of class
