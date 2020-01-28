package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshallingTest {

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
			JAXBContext context=JAXBContext.newInstance(EmployeeInfoBean.class);
			Marshaller marshaller=context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(employeeInfoBean, System.out);
			marshaller.marshal(employeeInfoBean, new File("employeeInfo.xml"));
		} catch (JAXBException e) {
			
			e.printStackTrace();
			System.err.println("Unable To Marshall!!!!");
		}
		
		
		
	}

}
