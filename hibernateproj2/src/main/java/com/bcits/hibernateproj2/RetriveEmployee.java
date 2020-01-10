package com.bcits.hibernateproj2.bean.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RetriveEmployee {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = entityManagerFactory.createEntityManager();
		Test2 info = manager.find(Test2.class, 1);
		// Test2 info = manager.getReference(Test2.class, 11114323);

		System.out.println(info.getClass());

		System.out.println("============================================================================");
		System.out.println("Employee ID          ===>" + info.getEMPID());
		System.out.println("Employee Name        ===>" + info.getNAME());
		System.out.println("Employee Salary      ===>" + info.getSALARY());
		System.out.println("Employee Designation ===>" + info.getDESIGNATION());
		System.out.println("Employee DeptID      ===>" + info.getDEPTID());
		System.out.println("Employee MobileNO    ===>" + info.getMOBILENO());
		System.out.println("Employee DOB         ===>" + info.getDOB());
		System.out.println("Employee DOJ         ===>" + info.getDOJ());

		System.out.println("---------------------------------------------------------------------------");
		manager.close();

	}// End Of Method

}// End Of Class
