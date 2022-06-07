package vn.iotstar.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/seller/product/list" })
public class SellerProductListController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4421408568702512876L;
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String userid = req.getParameter("userid");
		List<ProductModel> productList = productService.getProductByUseridSeller(userid);
		req.setAttribute("productlist", productList);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/product-list.jsp");
		dispatcher.forward(req, resp);
	}
}
