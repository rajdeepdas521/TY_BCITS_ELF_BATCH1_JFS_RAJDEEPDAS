package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnmarshalling {
	
	public static void main(String[] args) {
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			EmployeeInfoBean employeeInfoBean =mapper.readValue(new File("empJson2.json"), EmployeeInfoBean.class);
			

			System.out.println("Emp ID  ="+employeeInfoBean.getEmpId());
			System.out.println("Name  ="+employeeInfoBean.getName());
			System.out.println("Salary ="+employeeInfoBean.getSalary());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
