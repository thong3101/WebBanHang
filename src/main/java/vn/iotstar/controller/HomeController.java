package vn.iotstar.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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


@WebServlet(urlPatterns= {"/home","/trang-chu"})
public class HomeController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 676668436510454076L;
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiet lap tieng viet
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// lấy tham số từ JSP
		
		String indexPage = req.getParameter("index");
		String cid = req.getParameter("cid");
		String typeProduce = req.getParameter("typeProduce");
		
	
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		
		
		/*if (cid == null) {
			cid = "0";
		}
		;
		if(typeProduce == null) {
			typeProduce = "0";
		}
		List<ProductModel> listPC = productService.getAllProducteByCid(cid,typeProduce);
		List<ProductModel> productListAll = productService.getAllProduct(typeProduce);
		
		if ("0".equals(cid)) {
			req.setAttribute("productListAll", productListAll);
		}
		else
		{
			req.setAttribute("productListAll", listPC);
		}*/
		
		if (cid == null) {
			cid = "0";
		}
		
		if(typeProduce == null) {
			typeProduce = "0";
		}
		
		if ("0".equals(cid)) {
			int count = productService.countAll();
			int endPage = count / 10;
			if (count % 10 != 0) {
				endPage++;
			}
			List<ProductModel> list = productService.getAllProduct(typeProduce, index);
			req.setAttribute("endP", endPage);
			req.setAttribute("productListAll", list);
		}
		else {
			int count = productService.countCid(cid);
			int endPage = count / 10;
			if (count % 10 != 0) {
				endPage++;
			}
			List<ProductModel> listPCate = productService.getAllProducteByCid(cid,typeProduce,index);
			req.setAttribute("productListAll", listPCate);
			req.setAttribute("endP", endPage);
		}
		
		

		
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		req.setAttribute("tagactiveTypeProduce", typeProduce);

		
		List<CategoryModel> CategoryListAll =  categoryService.getAllCategory();
		req.setAttribute("CategoryListAll", CategoryListAll);
		
	
		
		
		//buoc 4: tra ve trang chu JSP
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	
	
}
