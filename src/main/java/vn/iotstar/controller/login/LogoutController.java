package vn.iotstar.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns= {"/logout"})
public class LogoutController extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -6868216906333242182L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session  = req.getSession();
		session.removeAttribute("acc");
		resp.sendRedirect(req.getContextPath()+"/login");
	}
}
