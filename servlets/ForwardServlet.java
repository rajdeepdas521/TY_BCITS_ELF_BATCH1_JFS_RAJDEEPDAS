package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.PrintWriterWithSMAP;
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// String url="./currentDate"; // (dynamic resource)  
	String url="./date.html";      // (Static resource)
	
	
	RequestDispatcher requestDispatcher=req.getRequestDispatcher(url);
	requestDispatcher.forward(req, resp);
}
}
