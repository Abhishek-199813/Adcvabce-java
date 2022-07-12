package cdac.webprojectday2;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class Register {
		
	public boolean isPresentCustomer(String email)
	{ 
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek", "root", "cdac");
			
			boolean present = false;
			
			
			PreparedStatement st1 = conn.prepareStatement("SELECT * FROM customer where email = ?");
			st1.setString(1,email);
			
			ResultSet rs = st1.executeQuery();
			checkDuplicateEmail checkDuplicateEmail = new checkDuplicateEmail();
			boolean isValid;
			
			while(rs.next())
			{
				String emailcounter = rs.getString("email");
				isValid = checkDuplicateEmail.emailCheck(emailcounter, email);
				if(isValid)
				{
					System.out.println("Email is already Exists");
					//PrintWriter out = response.getWriter();
				
				}
			}
			
			
			
			
			return present;
			
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			}
			catch(Exception e)
			{
				}
			}
		}
		
		
	public void registercustomer(String name , String email, int mobileNo,String username, String password) throws ClassNotFoundException
		{
		
			Connection conn = null;
			try {

				
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek", "root", "cdac");
				
				PreparedStatement st = conn.prepareStatement("insert into customer(name, email, mobileno, username, password) values(?, ?, ?, ?, ?)");
				st.setString(1, name); //substituting ? with actual value
				st.setString(2, email);
				st.setInt(3, mobileNo);
				st.setString(4, username);
				Base64.Encoder enc = Base64.getEncoder();
				String encoded = enc.encodeToString(password.getBytes());
				st.setString(5, encoded);
				st.executeUpdate();
				conn.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
				
			}
			finally
			{
				try {
					conn.close();
				}
				catch(Exception e)
				{
					
				}
			}
			
		
		
		
	}	
	
}








	
	

