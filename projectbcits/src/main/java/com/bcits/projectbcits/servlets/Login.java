package com.bcits.projectbcits.servlets;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import javax.persistence.Query;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import com.bcits.projectbcits.bean.ConsumerMaster;



	@WebServlet("/login")
	public class Login extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			int empIdVal = Integer.parseInt(req.getParameter("empId"));
			String password = req.getParameter("password");

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			EntityManager manager = emf.createEntityManager();

			String jpql = "from EmployeePrimaryInfo where empId=:empId and password=:pwd";
			Query query = manager.createQuery(jpql);
			query.setParameter("empId", empIdVal);
			query.setParameter("pwd", password);

			ConsumerMaster employeePrimaryInfo = null;
			try {
				employeePrimaryInfo = (ConsumerMaster) query.getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			if (employeePrimaryInfo != null) {
				// valid credentials
				// create the session
				HttpSession session = req.getSession(true);
				session.setMaxInactiveInterval(60);
				
				
				session.setAttribute("employeePrimaryInfo", employeePrimaryInfo);

				out.println("<h1 Style='color: blue'>Welcome " + employeePrimaryInfo.getName() + "</h1>");

				RequestDispatcher dispatcher = req.getRequestDispatcher("./employeeHome.html");
				dispatcher.include(req, resp);

			} else {
				out.println("<h1 Style='color: red'>Invalid Credential !!!</h1> ");

				RequestDispatcher dispatcher = req.getRequestDispatcher("./loginForm.html");
				dispatcher.include(req, resp);
			}

			out.println("</body>");
			out.println("</html>");
			manager.close();
			emf.close();

		}
	}


