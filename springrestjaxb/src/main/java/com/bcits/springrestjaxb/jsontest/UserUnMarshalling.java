package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnMarshalling {
	
	public static void main(String[] args) {
			
			try {
				ObjectMapper mapper=new ObjectMapper();
				UserInfoBean employeeInfoBean =mapper.readValue(new File("empJson5.json"), UserInfoBean.class);
				

				System.out.println("Emp ID  ="+employeeInfoBean.getEmpId());
				System.out.println("Name  ="+employeeInfoBean.getName());
				System.out.println("Salary ="+employeeInfoBean.getSalary());
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
		}
	}


