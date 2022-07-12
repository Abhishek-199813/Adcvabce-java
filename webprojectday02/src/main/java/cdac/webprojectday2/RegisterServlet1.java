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
@WebServlet("/register1.cdac")
public class RegisterServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String emailcounter;
		Base64.Encoder enc = Base64.getEncoder();
		
		//jdbc code to insert the data
		//TODO: first create the table in the Database
		//create table tbl_customer(id int primary key auto_increment, name varchar(20), email varchar(30), mobileno int, username varchar(15), password varchar(8));
		//Also we need to download the jdbc driver for mysql and then
		//copy the mysql-connector-java-...jar to WEB-INF/lib folder of our project
		//TODO: store the password in encoded form in the database (use base64 encoding)
		//TODO: before inserting, you will check by firing a select query 
		//		whether there is already a customer registered by the same email address
		//		if yes, then another record should not get inserted
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek", "root", "cdac");
			
			PreparedStatement st1 = conn.prepareStatement("SELECT * FROM customer where email = ?");
			st1.setString(1,email);
			ResultSet rs = st1.executeQuery();
			checkDuplicateEmail checkDuplicateEmail = new checkDuplicateEmail();
			boolean isValid = false;
		while(rs.next()) {
			
			emailcounter = rs.getString("email");
			
			isValid = checkDuplicateEmail.emailCheck(emailcounter, email);
			
		}
			
			if(!isValid)
			{
				System.out.println("Email does not Exists");
				PreparedStatement st = conn.prepareStatement("insert into customer(name, email, mobileno, username, password) values(?, ?, ?, ?, ?)");
				st.setString(1, name); //substituting ? with actual value
				st.setString(2, email);
				st.setInt(3, mobileNo);
				st.setString(4, username);
				String encoded = enc.encodeToString(password.getBytes());
				st.setString(5, encoded);
				st.executeUpdate();
				conn.close();
				
			}
			else
			{
				System.out.println("Email is already Exists");
				PrintWriter out = response.getWriter();
				out.write("<html><body>");
				out.write("<h1>Registration cannot be sucessful because email is already registered!</h1>");
				out.write("</body></html>");
			
			}
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Registration successful!</h1>");
		out.write("</body></html>");
	}

}
