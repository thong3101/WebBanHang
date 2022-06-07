package vn.iotstar.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import vn.iotstar.model.AcountModel;
import vn.iotstar.service.LoginService;
import vn.iotstar.service.impl.LoginServiceImpl;

@WebServlet(urlPatterns = { "/signup" })
public class SignupController extends HttpServlet{


	private static final long serialVersionUID = -6802601526744014557L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		LoginService loginService = new LoginServiceImpl();
		
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String role = req.getParameter("role");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rpassword = req.getParameter("rpassword");
		
		
		AcountModel acount = new AcountModel();
		acount.setFullName(name);
		acount.setEmail(email);
		acount.setAddress(address);
		acount.setPhone(phone);
		acount.setIsSeller(Integer.parseInt(role));
		acount.setUsername(username);
		acount.setPassword(password);
		
		AcountModel acount1 = loginService.checkAcc(acount.getUsername());
		if(acount1 == null) {
			loginService.signup(acount);
			String mess = "Dang ki thanh cong";
			resp.sendRedirect(req.getContextPath()+"/login?message="+mess);
		}else {
			String mess = "Ten dang nhap da ton tai";
			resp.sendRedirect(req.getContextPath()+"/login?message="+mess);
		}
		
		
		
		/*AcountModel acount = new AcountModel();
		acount.setFullName(name);
		acount.setEmail(email);
		acount.setAddress(address);
		acount.setPhone(phone);
		acount.setIsSeller(Integer.parseInt(role));
		acount.setUsername(username);
		acount.setPassword(password);
		loginService.signup(acount);*/
		
		/*if(!password.equals(rpassword)) {
			req.setAttribute("mess", "Nhập lại password không khớp với password");
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			
		}else {
			AcountModel acount = loginService.checkAcc(username);
			AcountModel acount = new AcountModel();
			acount.setFullName(name);
			acount.setEmail(email);
			acount.setAddress(address);
			acount.setPhone(phone);
			acount.setIsSeller(Integer.parseInt(role));
			acount.setUsername(username);
			acount.setPassword(password);
			
			AcountModel acount1 = loginService.checkAcc(acount.getUsername());
			if(acount1 == null) {
				loginService.signup(acount);
				req.setAttribute("mess", "Đăng kí thành công");
				req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			}else {
				req.setAttribute("mess", "Tên đăng nhập đã tồn tại");
				req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
				
			}
		}*/
		
	}
}
