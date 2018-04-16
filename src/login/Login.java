package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		System.out.println(email+" "+pass);
		LoginBean bean = new LoginBean();
		bean.setEmail(email);
		bean.setPass(pass);
		
		RequestDispatcher rd = req.getRequestDispatcher("/LoginDao");
		req.setAttribute("user", bean);
		rd.forward(req, res);
	}
}
