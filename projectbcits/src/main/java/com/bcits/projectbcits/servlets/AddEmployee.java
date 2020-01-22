package com.bcits.projectbcits.servlets;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.bcits.projectbcits.bean.ConsumerMaster;
	@WebServlet("/addEmployee")
	public class AddEmployee extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String empIdVal = req.getParameter("meterNumber");
			String nameVal = req.getParameter("name");
			String mailVal = req.getParameter("mailId");
			String addressVal = req.getParameter("address");
			String mobileVal = req.getParameter("mobilenum");
			String regionVal = req.getParameter("region");
			String passwordVal =req.getParameter("password");
			
			
			ConsumerMaster consumerMaster = new ConsumerMaster();
			consumerMaster.setMeterNumber(Integer.parseInt(empIdVal));
			consumerMaster.setName(nameVal);
			consumerMaster.setMailId(mailVal);
			consumerMaster.setAddress(addressVal);
			consumerMaster.setMobilenum(Long.parseLong(mobileVal));
			consumerMaster.setRegion(regionVal);
			consumerMaster.setPassword(passwordVal);
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			boolean isAdded = false;
			try {
				tx.begin();
				manager.persist(consumerMaster);
				tx.commit();
				isAdded= true;
			} catch(Exception e) {
				e.printStackTrace();
			}
			manager.close();
			emf.close();
			
			
			PrintWriter out= resp.getWriter();
			 out.println("<html>");
			 out.println("<body>");
			 if(isAdded) {
				 out.println("<h1 style='color:green'>Employee Record for Id "  + empIdVal+"Inserted</h1>");
			 } else {
				 //not added
				 out.println("<h1 style='color:red'>Unable to add employee record!!!</h1>");
			 }
			out.println("</body>");
			out.println("</html>");
		}
		
	}