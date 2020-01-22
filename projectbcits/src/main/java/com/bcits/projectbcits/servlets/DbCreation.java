package com.bcits.projectbcits.servlets;

import javax.servlet.http.HttpServlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.projectbcits.bean.EmployeeMaster;

public class DbCreation{

	public static void main(String[] args) {
		EntityManager manager=null;
		EntityTransaction transaction=null;
		
		
		 EmployeeMaster employeeMaster =new EmployeeMaster();
		 employeeMaster.setEmployeeId(11);
		 employeeMaster.setPassword("Rajesh");
		 employeeMaster.setName("Rajesh M");
		 employeeMaster.setEmail("Rajesh8422@gmail.com");
		 employeeMaster.setRegion("");
		 
		 try {
		 EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("emsPersistenceUnit");
		 manager = entityManagerFactory.createEntityManager();
		 transaction =manager.getTransaction();
		 transaction.begin();
		 manager.persist(employeeMaster);
		 System.out.println("record saved");
		 transaction.commit();
		 }catch(Exception e) {
			 e.getStackTrace();
			 if (transaction != null) {
				transaction.rollback();
			}
			 
		 }finally {
			 if(manager != null) {
				 manager.close();
			 }
		 }
	}
}

