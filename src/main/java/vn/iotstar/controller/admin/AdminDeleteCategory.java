package vn.iotstar.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class AdminDeleteCategory extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7604640994811912871L;
	CategoryService cateService = new CategoryServiceImpl();
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		
		int count = productService.countCid(id);
		if(count==0) {
			cateService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		}else {
			String mess ="Van con san pham cua category nay";
			resp.sendRedirect(req.getContextPath() + "/admin/category/list?mess="+mess);
		}
	}
}
