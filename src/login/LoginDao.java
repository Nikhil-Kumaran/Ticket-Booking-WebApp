package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/LoginDao"})
public class LoginDao extends HttpServlet {
	Connection conn;
	String error = null;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/ticketwebapp?autoReconnect=true&useSSL=false","root","ritesh2005");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        error = null;
		LoginBean b = (LoginBean) req.getAttribute("user");
		System.out.println(b.getEmail());
		if(b.getEmail().equals("") || b.getPass().equals("")) {
			error = "enter all the values";
		}
		else {
			try {
				PreparedStatement query=conn.prepareStatement("select * from users where email=?");
	            query.setString(1, b.getEmail());
	            ResultSet rs = query.executeQuery();
	            if(!rs.next()) {
	            	error = b.getEmail()+" is not a registered user";
	            }
	            else if(!rs.getString("password").equals(b.getPass())) {
	            	error = "Incorrect Password";
	            }
	            else {
	            	error = null;
	            	b.setName(rs.getString(2));
	            }
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		if(error != null) {
			System.out.println(error);
			req.setAttribute("err", error);
			error = null;
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//			PrintWriter out= res.getWriter();
//			out.println("<font class='error'>"+error+"</font>");
			
			
			rd.forward(req, res);
		}
		else {
			
			HttpSession ses = req.getSession();
			ses.setAttribute("user", b);
			res.sendRedirect("welcome.jsp");
		}
	}
}
