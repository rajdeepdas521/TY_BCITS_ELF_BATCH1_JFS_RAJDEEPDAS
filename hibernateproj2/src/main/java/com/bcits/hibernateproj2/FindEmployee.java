package com.bcits.hibernateproj2.bean.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployee {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
	EntityManager manager=entityManagerFactory.createEntityManager();
	Test2 info=	manager.find(Test2.class, 1);
    System.out.println("------------------------------------------------------------");
	System.out.println("Employee ID------>"+info.getEMPID());
	System.out.println("Employee Name---------->"+info.getNAME());
	System.out.println("Employee Salary------>"+info.getSALARY());
	System.out.println("Employee Mobile No"+info.getMOBILENO());
	
  }// End Of The method
}// End Of The Class
