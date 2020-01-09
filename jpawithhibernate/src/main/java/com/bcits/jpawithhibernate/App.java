package com.bcits.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.bean.Test;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Test test = new Test();
		test.setMid(2);
		test.setMovieName("bahubali");
		test.setMovieRating("Best");

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
