package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;
import com.bcits.springcore.beans.EmployeeBean1;

public class EmployeeTest2 {
  public static void main(String[] args) {
	 
	  ApplicationContext context =new ClassPathXmlApplicationContext("employeeConfig.xml");
	  EmployeeBean1 employeeBean1 =context.getBean("employee", EmployeeBean1.class);
	  
	  System.out.println("Name = "+employeeBean1.getName());
	  System.out.println("Age = "+employeeBean1.getAge());
	  System.out.println("Dept Id = "+employeeBean1.getDepartmentBean().getDeptId());
	  System.out.println("Dept Name = "+employeeBean1.getDepartmentBean().getDeptName());
	  
}
}
