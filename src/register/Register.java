package register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private String name = null,email = null, password = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		name = req.getParameter("name");
		email = req.getParameter("email");
		password = req.getParameter("pass");
		
		RegisterBean bean = new RegisterBean();
		bean.setName(name);
		bean.setEmail(email);
		bean.setPassword(password);
		
		req.setAttribute("user_bean", bean);
		
		RequestDispatcher rd = req.getRequestDispatcher("/db");
		rd.forward(req, res);
		
	}

}
