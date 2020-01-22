package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeBean employeeBean = (EmployeeBean) applicationContext.getBean("employee");
		
		System.out.println("Enter Employee name :");
		employeeBean.setName(sc.nextLine());
		System.out.println("Enter Employee Age :");
		employeeBean.setAge(sc.nextInt());
		sc.nextLine();
		
		EmployeeBean employeeBean2 = (EmployeeBean) applicationContext.getBean("employee");

		System.out.println("Enter Employee name :");
		employeeBean2.setName(sc.nextLine());
		System.out.println("Enter Employee Age :");
		employeeBean2.setAge(sc.nextInt());
		
		System.out.println("Name :-" + employeeBean.getName());
		System.out.println("Age :-" + employeeBean.getAge());
		System.out.println("Name :-" + employeeBean2.getName());
		System.out.println("Age :-" + employeeBean2.getAge());

	}
}
