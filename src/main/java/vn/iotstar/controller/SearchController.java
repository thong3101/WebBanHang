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

@WebServlet(urlPatterns= {"/search"})
public class SearchController extends HttpServlet {

	/**
	 * 
	 */
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	private static final long serialVersionUID = 2663367006258617424L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Thiet lap tieng viet
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// lấy tham số từ JSP
		
		String cid = req.getParameter("cid");
		String typeProduce = req.getParameter("typeProduce");
		
	
		if (cid == null) {
			cid = "0";
		}

		if(typeProduce == null) {
			typeProduce = "0";
		}
	
		req.setAttribute("tagactive", cid);
		req.setAttribute("tagactiveTypeProduce", typeProduce);

		
		List<ProductModel> productTop10 = productService.get10Product();
		req.setAttribute("productTop10", productTop10);
		
		
		List<CategoryModel> CategoryListAll =  categoryService.getAllCategory();
		req.setAttribute("CategoryListAll", CategoryListAll);
		
		String txt1 = req.getParameter("txt");
		req.setAttribute("txtS", txt1);
		
		List<ProductModel> ListProductSearch = productService.getAllProductBySearch(txt1);
		req.setAttribute("productListAll", ListProductSearch);
		
	
		
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
	}
	
}
