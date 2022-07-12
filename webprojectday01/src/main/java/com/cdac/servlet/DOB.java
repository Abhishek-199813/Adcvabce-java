package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DOB
 */
@WebServlet("/DOB.cdac")
public class DOB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     

		String dob = request.getParameter("number1");
		
		
		LocalDate dob1 = LocalDate.parse(dob);
		
		LocalDate cdate = LocalDate.now();
		
		
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		   
		   out.write("<html><body>");
		   out.write("<h1>your age is " + Period.between(dob1,cdate).getYears() + "</h1>" );
		   out.write("</body></html>");
		   
		   
	}

	

}
