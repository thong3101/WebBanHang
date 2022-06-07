package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/list" })
public class AdminCategoryListController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5835608381746459467L;
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String mess = req.getParameter("mess");
		List<CategoryModel> categoryModel = categoryService.getAllCategory();
		req.setAttribute("cate", categoryModel);
		req.setAttribute("mess", mess);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category-list.jsp");
		dispatcher.forward(req, resp);
	}
}
