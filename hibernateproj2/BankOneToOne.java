package com.bcits.jpawithhibernatemap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.hibernateproj2.bean.crud.PrimaryInfo;
import com.bcits.jpawithhibernate.onetoone.BankEmployeeInfo;

public class BankOneToOne {
  public static void main(String[] args) {
	
	  

		EntityTransaction transaction = null;
		EntityManager manager = null;

		PrimaryInfo test = new PrimaryInfo();

		test.setEMPID(579);
		test.setNAME("amrita");
		test.setMOBILENO(9763541234l);
		test.setOFFICIAL_MAILID("SUNIDHI12@gmail.com");
		test.setDOB(java.sql.Date.valueOf("1995-2-20"));
		test.setDOJ(java.sql.Date.valueOf("2019-10-14"));
		test.setDESIGNATION("TESTER");
		test.setBLOODGROUP("B+");
		test.setSALARY(24000);
		test.setDEPTID(20);
		test.setMANAGERID(102);
		
		BankEmployeeInfo info= new BankEmployeeInfo();
		
		info.setAccountno(2233887733l);
		info.setBankName("state bank of india");
		info.setBranchName("dhanbad");
		info.setIfsc_code("abc123400");
		info.setTest(test);
		

		try {
			EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");
			manager = enf.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
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
