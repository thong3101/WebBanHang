package vn.iotstar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class AdminAddCategoryController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7798477570333291628L;

	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category-add.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		CategoryModel category = new CategoryModel();
		String cname = req.getParameter("name");
		System.out.print(cname);
		
		CategoryModel checkcate = categoryService.get(cname);
		
		if(checkcate==null) {
			category.setCname(cname);
			categoryService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		}
		else {
			req.setAttribute("mess", "Category đã có");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category-add.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
