package com.bcits.hibernateproj2.bean.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEmployee {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Test2 info = manager.find(Test2.class, 11);
			manager.remove(info);
			transaction.commit();
			System.out.println("Record Deleted");
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}
}
