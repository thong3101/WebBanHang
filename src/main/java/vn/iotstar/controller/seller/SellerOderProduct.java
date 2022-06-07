package vn.iotstar.controller.seller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/seller/product-order/list"})
public class SellerOderProduct extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2822861122404382772L;
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		String userid = req.getParameter("userid");
		String date = req.getParameter("date");
		
		List<CartItemModel> cartitem = productService.sanPhamOrder(userid);
		req.setAttribute("cartitem", cartitem);
		req.setAttribute("date", date);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/product-oder-list.jsp");
		dispatcher.forward(req, resp);
	}
	
	/*public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        System.out.println(strDate);
	}*/
	
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
		

		
		List<CartItemModel> cartitem = productService.Thongke(userid, date);
		req.setAttribute("cartitem", cartitem);
		req.setAttribute("date",date);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/product-oder-list.jsp");
		dispatcher.forward(req, resp);
	}
}
