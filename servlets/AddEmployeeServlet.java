package com.bcits.empwebapp.servlets;

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

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("name");
		String designationVal = req.getParameter("designation");
		String salaryVal = req.getParameter("salary");
		String mobileVal = req.getParameter("mobilenum");
		String passwordVal = req.getParameter("password");
		String joiningDateVal =req.getParameter("doj");
		
		SimpleDateFormat dateFormat =new SimpleDateFormat();
		Date joiningDate=null;
		try {
			joiningDate = dateFormat.parse(joiningDateVal);
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		EmployeePrimaryInfo employeePrimaryInfo = new EmployeePrimaryInfo();
		employeePrimaryInfo.setEmpId(Integer.parseInt(empIdVal));
		employeePrimaryInfo.setName(nameVal);
		employeePrimaryInfo.setDesignation(designationVal);
		employeePrimaryInfo.setSalary(Double.parseDouble(salaryVal));
		employeePrimaryInfo.setMobilenum(Long.parseLong(mobileVal));
		employeePrimaryInfo.setPassword(passwordVal);
		employeePrimaryInfo.setDoj(joiningDate);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(employeePrimaryInfo);
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
