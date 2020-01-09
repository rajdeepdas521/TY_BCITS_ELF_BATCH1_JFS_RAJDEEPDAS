package com.bcits.hibernateproj2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.hibernateproj2.bean.Test2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Test2 test=new Test2();
      test.setEMPID(12);
      test.setNAME("DEVA");
      test.setMOBILENO(900000123);
      test.setOFFICIAL_MAILID("DEVASISH12@gmail.com");
      test.setDOB(java.sql.Date.valueOf("1992-2-2"));
      test.setDOJ(java.sql.Date.valueOf("1992-2-2"));
      test.setDESIGNATION("DEVELOPER");
      test.setBLOODGROUP("A+");
      test.setSALARY(20000);
      test.setDEPTID(10);
      test.setMANAGERID(101);
      
      EntityManagerFactory enf = Persistence.createEntityManagerFactory("test");
		EntityManager manager = enf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(test);
		System.out.println("Record Saved");
		transaction.commit();
		manager.close();
    }
}
