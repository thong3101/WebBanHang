package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns= {"/productdetail"})
public class productDetailController extends HttpServlet {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = -816234093980724869L;
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String pid = req.getParameter("pid");
		String cid = req.getParameter("cid");
		
		
		List<CategoryModel> listCate = categoryService.getAllCategory();
		req.setAttribute("listCategory", listCate);
		
		CategoryModel ProductCate = categoryService.getProductCateByid(cid);
		req.setAttribute("categoryName", ProductCate);
		
		ProductModel productDetail = productService.getProductByid(pid);
		req.setAttribute("productDetail", productDetail);	
		
		req.getRequestDispatcher("/views/productDetail.jsp").forward(req, resp);
	}
}
