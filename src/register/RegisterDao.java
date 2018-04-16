package register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = { "/db" })
public class RegisterDao extends HttpServlet{
	Connection conn;
	String error = null;
	public RegisterDao() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/ticketwebapp?autoReconnect=true&useSSL=false","root","ritesh2005");

	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		RegisterBean b = (RegisterBean) req.getAttribute("user_bean");
		
		if(b.getName().equals("") || b.getEmail().equals("") || b.getPassword().equals("")) {
			error = "enter all the values";
		}
		else {
			PreparedStatement query;
			try {
				query = conn.prepareStatement("insert into users (name,email,password) values(?,?,?)"); 
	            //String sqlQuery = "insert into e_book (name,email,pass) values('"+text1+"','"+text2+"','"+text3+"')";
	            query.setString(1,b.getName());
	            query.setString(2,b.getEmail());
	            query.setString(3,b.getPassword());
	            query.executeUpdate();
			}
			catch(SQLIntegrityConstraintViolationException prime){
				error = b.getEmail()+" You are already a registered user";
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(error != null) {
				RequestDispatcher rd = req.getRequestDispatcher("/signup.jsp");
				PrintWriter out= res.getWriter();
				out.println("<font color=red>"+error+"</font>");
				rd.include(req, res);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				PrintWriter out= res.getWriter();
				out.println("<font color=green>Registration successful, please login below.</font>");
				rd.include(req, res);
			}
		}
	}
	
}
