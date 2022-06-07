package vn.iotstar.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;
import vn.iotstar.service.LoginService;
import vn.iotstar.service.impl.LoginServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4726963151163355729L;
	public static final String SESSION_USERNAME = "user";
	public static final String COOKIE_REMEMBER = "user";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String message = req.getParameter("message");
		req.setAttribute("mess", message);
		
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("acc") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					session = req.getSession(true);
					session.setAttribute("user", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("user");
		String password = req.getParameter("pass");


		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		LoginService loginService = new LoginServiceImpl();

		AcountModel acount = loginService.login(username, password);

		if (username.isEmpty() || password.isEmpty()) {
			req.setAttribute("mess", "Nhập tài khoản mập khẩu");
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			return;
		}else if (acount != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("acc", acount);

			if (isRememberMe) {
				saveRememberMe(resp, username);
			}

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			req.setAttribute("mess", "Sai tài khoản mật khẩu");
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}
	}

	private void saveRememberMe(HttpServletResponse resp, String username) {
		// TODO Auto-generated method stub
		Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		resp.addCookie(cookie);
	}
}
