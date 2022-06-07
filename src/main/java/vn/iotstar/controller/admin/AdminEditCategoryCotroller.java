package vn.iotstar.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/edit" })
public class AdminEditCategoryCotroller extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5268737597464870611L;
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		CategoryModel cate = categoryService.getProductCateByid(id);
		req.setAttribute("cate", cate);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category-edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String cid = req.getParameter("id");
		String cname = req.getParameter("name");
		
		CategoryModel category= new CategoryModel();
		category.setCid(Integer.parseInt(cid));
		category.setCname(cname);
		
		categoryService.edit(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
