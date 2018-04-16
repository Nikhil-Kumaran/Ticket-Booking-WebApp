package movies;

import java.io.IOException;
import login.LoginBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Movie
 */
@WebServlet(urlPatterns = {"/Movies"})
public class Movie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("name"));
		HttpSession ses = request.getSession();
		LoginBean bn = (LoginBean) ses.getAttribute("user");
		System.out.println(bn.getName());
	}

}
