package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.AcountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = { "/admin/user/list" })
public class UserListController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1742941976016315381L;
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String mess = req.getParameter("mess");
		req.setAttribute("mess", mess);
		
		List<AcountModel> user = userService.getAllUser();
		req.setAttribute("userlist", user);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user-list.jsp");
		dispatcher.forward(req, resp);
	}
}
