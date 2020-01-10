package com.bcits.hibernateproj2.bean.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Reattached {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Test2 info = manager.find(Test2.class, 1);
			System.out.println(manager.contains(info));
			manager.detach(info);
			System.out.println(manager.contains(info));
			Test2 reTst = manager.merge(info);// Merge Method Helps Us To Re-Attached The DeAttached Object.
			reTst.setSALARY(80000);
			transaction.commit();
			System.out.println("Record Updated");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}

}
