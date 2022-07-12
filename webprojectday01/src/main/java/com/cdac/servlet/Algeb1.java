package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Algeb
 */



@WebServlet("/Algeb1.cdac")
public class Algeb1 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   int num1 = Integer.parseInt(request.getParameter("number1"));
	   int num2 = Integer.parseInt(request.getParameter("number2"));
	   
	   
	   if(request.getParameter("submit1")!=null)
	   {
	   int num3 = num1 + num2;
	   
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   
	   out.write("<html><body>");
	   out.write("<h1>the solution is " + num3 + "</h1>" );
	   out.write("</body></html>");
	   
	   }
	   else if(request.getParameter("submit2")!=null)
	   {
	   int num3 = num1 - num2;
	   
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   
	   out.write("<html><body>");
	   out.write("<h1>the solution is " + num3 + "</h1>" );
	   out.write("</body></html>");
	   
	   }
	
	
	}

	

}
