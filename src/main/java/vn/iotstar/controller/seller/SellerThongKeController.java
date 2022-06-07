package vn.iotstar.controller.seller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/seller/thongke" })
public class SellerThongKeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9180872325240835068L;
	CategoryService categoryService = new CategoryServiceImpl();
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String userid = req.getParameter("userid");
		String date = req.getParameter("date");
		
		List<ProductModel> product = productService.getProductByUseridSeller(userid);
		List<CartItemModel> cartitem = productService.ThongkeSLSanDaBan(userid);

		
		req.setAttribute("product", product);
		req.setAttribute("cartitem", cartitem);
		req.setAttribute("date", date);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/sellerthongke.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String userid = String.valueOf(a.getUid());
		String date = req.getParameter("from_date");
		
		
		List<ProductModel> product = productService.getProductByUseridSeller(userid);
		List<CartItemModel> cartitem = productService.ThongkeSLSanDaBanTheoNgay(userid,date);
		
		req.setAttribute("product", product);
		req.setAttribute("cartitem", cartitem);
		req.setAttribute("date",date);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/sellerthongke.jsp");
		dispatcher.forward(req, resp);
	}
}
