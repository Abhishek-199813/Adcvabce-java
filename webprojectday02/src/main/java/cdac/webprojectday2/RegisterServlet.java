package cdac.webprojectday2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.cdac")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String emailcounter;
		
		
		
		//jdbc code to insert the data
		//TODO: first create the table in the Database
		//create table tbl_customer(id int primary key auto_increment, name varchar(20), email varchar(30), mobileno int, username varchar(15), password varchar(8));
		//Also we need to download the jdbc driver for mysql and then
		//copy the mysql-connector-java-...jar to WEB-INF/lib folder of our project
		//TODO: store the password in encoded form in the database (use base64 encoding)
		//TODO: before inserting, you will check by firing a select query 
		//		whether there is already a customer registered by the same email address
		//		if yes, then another record should not get inserte
			
			
			
			Register register = new Register();
			boolean isPresent = register.isPresentCustomer(email);
			
			
			
			PrintWriter out = response.getWriter();
			out.write("<html><body>");
			
			if(isPresent) {
				out.write("<h1>It seems you are already a registered user!</h1>");
			}
			else
			{
				try {
					register.registercustomer(name,email,mobileNo,username,password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.write("<h1>you are sucessfully a registered user!</h1>");
			}
			out.write("</body></html>");

		
			
	
			
		}
		

}
