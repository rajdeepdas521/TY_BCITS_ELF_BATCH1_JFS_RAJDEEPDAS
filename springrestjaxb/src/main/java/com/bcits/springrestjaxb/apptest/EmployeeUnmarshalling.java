package com.bcits.springrestjaxb.apptest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnmarshalling {
  public static void main(String[] args) {
	 JAXBContext jaxbContext;
	 try {
		jaxbContext=JAXBContext.newInstance(EmployeeInfoBean.class);
		Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
		
		EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)unmarshaller.unmarshal(new File("employeeInfo2.xml"));
		
		System.out.println("Emp ID  ="+employeeInfoBean.getEmpId());
		System.out.println("Name  ="+employeeInfoBean.getName());
		System.out.println("Salary ="+employeeInfoBean.getSalary());
		
	} catch (JAXBException e) {
	
		e.printStackTrace();
	}
	  
   }// End of main()
  
}//End of Class
