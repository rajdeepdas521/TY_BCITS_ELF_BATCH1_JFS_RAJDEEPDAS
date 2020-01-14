package com.bcits.jpawithhibernatemap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.hibernateproj2.bean.crud.PrimaryInfo;
import com.bcits.jpawithhibernate.onetoone.EmployeeSecondaryInfo;

public class TestOneToOne {
	public static void main(String[] args) {

		EntityTransaction transaction = null;
		EntityManager manager = null;

		PrimaryInfo test = new PrimaryInfo();

		test.setEMPID(19);
		test.setNAME("raushan");
		test.setMOBILENO(9763541234l);
		test.setOFFICIAL_MAILID("raushan22@gmail.com");
		test.setDOB(java.sql.Date.valueOf("1997-5-14"));
		test.setDOJ(java.sql.Date.valueOf("2019-10-12"));
		test.setDESIGNATION("developer");
		test.setBLOODGROUP("A+");
		test.setSALARY(28000);
		test.setDEPTID(20);
		test.setMANAGERID(102);

		EmployeeSecondaryInfo secondaryInfo = new EmployeeSecondaryInfo();
		secondaryInfo.setPERSONAL_MAILID("raushanrock123@gmail.com");
		secondaryInfo.setGENDER("male");
		secondaryInfo.setMARTIAL_STATUS("unmarried");
		secondaryInfo.setNATIONALITY("INDIAN");
		secondaryInfo.setGUARDIAN_NAME("deepak");
		secondaryInfo.setGUARDIANNO(9800253417l);
		
		secondaryInfo.setAGE(25);
		
		secondaryInfo.setGOVTID("aadhar CARD");
		
		secondaryInfo.setPrimary(test);
		
		try {
			EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");
			manager = enf.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeeSecondaryInfo priInfo= manager.find(EmployeeSecondaryInfo.class, 5797);
			System.out.println(priInfo.getPERSONAL_MAILID());
			System.out.println(priInfo.getPrimary().getSALARY());
			//manager.persist(secondaryInfo);
			System.out.println("Record Saved");
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			manager.close();
		}
	}
}
