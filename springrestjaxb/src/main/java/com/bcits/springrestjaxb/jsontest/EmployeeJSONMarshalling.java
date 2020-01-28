package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONMarshalling {
	
	public static void main(String[] args) {
		
		EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
		employeeInfoBean.setEmpId(100);
		employeeInfoBean.setDeptId(20);
		employeeInfoBean.setDesignation("SSD");
		employeeInfoBean.setDob(new Date());
		employeeInfoBean.setJoiningDate(new Date());
		employeeInfoBean.setManagerId(10);
		employeeInfoBean.setMobile(7991153890L);
		employeeInfoBean.setName("Rajdeep");
		employeeInfoBean.setOfficialmailId("rajdeep842@gmail.com");
		employeeInfoBean.setPassword("qwerty");
		employeeInfoBean.setSalary(500000);
		employeeInfoBean.setBloodgroup("b+");
		
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();
			mapper.writeValue(new File("empJson3.json"), employeeInfoBean);
			mapper.writeValue(System.out, employeeInfoBean);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
