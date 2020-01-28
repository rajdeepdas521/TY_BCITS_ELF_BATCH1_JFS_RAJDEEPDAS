package com.bcits.springrestjaxb.apptest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnmarshalling {
	
	public static void main(String[] args) {
		 JAXBContext jaxbContext;
		 try {
			jaxbContext=JAXBContext.newInstance(UserInfoBean.class);
			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
			
			UserInfoBean userInfoBean=(UserInfoBean)unmarshaller.unmarshal(new File("userInfo.xml"));
			
			System.out.println("Emp ID  ="+userInfoBean.getEmpId());
			System.out.println("Name  ="+userInfoBean.getName());
			System.out.println("Salary ="+userInfoBean.getSalary());
			System.out.println("Gender ="+userInfoBean.getUserOtherInfoBean().getGender());
			System.out.println("AAdhar no ="+userInfoBean.getUserOtherInfoBean().getAadharNumber());
		;
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
		  
	}

}
