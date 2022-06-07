package vn.iotstar.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.service.ProductService;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/user/delete" })
public class UserDeleteController extends HttpServlet{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 654674220916655151L;
	UserService userS = new UserServiceImpl();
	ProductService proS = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		int count = proS.countProUid(id);
		
		if(count==0) {
			userS.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath() + "/admin/user/list");
		}else {
			String mess ="Nguoi dung nay van con san pham ban";
			resp.sendRedirect(req.getContextPath() + "/admin/user/list?mess="+mess);
		}
	}
}
