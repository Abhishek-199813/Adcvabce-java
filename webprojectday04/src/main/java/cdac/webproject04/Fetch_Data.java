package cdac.webproject04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fetch_Data
 */
@WebServlet("/Fetch_Data")
public class Fetch_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek", "root", "cdac");
			
			PreparedStatement st = con.prepareStatement("select * from customer");
			
			ResultSet rs =  st.executeQuery();
			
			PrintWriter out = response.getWriter();
			
			out.write("<html>");
			out.write("<head><style>");
			out.write("table, th, td {");
			out.write("border: 1px solid;}");
			out.write("</style></head><body>");
			out.write("<table>");
			out.write("<tr>");
			out.write("<th>Name</th>");
			out.write("<th>Email</th>");
			out.write("<th>mobileNo</th>");
			out.write("<th>username</th>");
			out.write("<th>password</th>");
			
			while(rs.next())
			{
				
				String name = rs.getString("name");
				System.out.println(name);
				String email = rs.getString("email");
				System.out.println(email);
				int mobileNo = rs.getInt("mobileno");
				System.out.println(mobileNo);
				String  username= rs.getString("username");
				System.out.println(username);
				String  password= rs.getString("password");
				System.out.println(password);
				System.out.println("");
				System.out.println("");
				
				
				
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td>"+name+"</td>");
				out.write("<td>"+email+"</td>");
				out.write("<td>"+mobileNo+"</td>");
				out.write("<td>"+username+"</td>");
				out.write("<td>"+password+"</td>");
				out.write("</tr>");
				out.write("<head></body></html>");
				
				
			}
			con.close();
				
		}
		catch(ClassNotFoundException | SQLException e)
		{
				e.printStackTrace();
		}
	}


}
