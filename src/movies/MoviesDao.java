package movies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoviesDao
 */
@WebServlet("/MoviesDao")
public class MoviesDao extends HttpServlet {
	Connection conn;
	int i = 0;
	Collection <String> movies_list = new ArrayList<String>();
	public MoviesDao() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/ticketwebapp?autoReconnect=true&useSSL=false","root","ritesh2005");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
			request.setAttribute("movies", movies_list);
			rd.forward(request, response);
		}else {
			try {
				PreparedStatement query=conn.prepareStatement("select * from movies_list");
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					movies_list.add(rs.getString("name"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			for(String mov : movies_list) {
				System.out.println(mov);
			}
			RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
			request.setAttribute("movies", movies_list);
			rd.forward(request, response);
			
		}
		
	}
}
