package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form.cdac")
public class helloServlet extends HttpServlet {
	
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fullname = request.getParameter("fullname");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Hello Servlet and today's date is" + fullname.toUpperCase() +"</h1>");
		out.write("</body></html>");
		
}
}