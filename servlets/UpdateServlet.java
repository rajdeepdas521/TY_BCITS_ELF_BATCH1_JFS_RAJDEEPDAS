package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/updateEmployee")
public class UpdateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);
		
		boolean isAdded=false;
		try {
			transaction.begin();
			transaction.commit(); 
			employeePrimaryInfo.setEmpId(22);
			isAdded=true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		out.println("<html>");
		out.println("<body>");
		if(isAdded) {
		out.println("<h1 style='color:red'>Employee ID" + empId + " Updated !!!</h1>");
		}else {
			out.println("<h1 style='color: green'> Employee ID" + empId + " Not Found !!!</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		manager.close();
		emf.close();

    	
    }
}
