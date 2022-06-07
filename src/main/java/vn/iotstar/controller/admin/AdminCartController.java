package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CartModel;
import vn.iotstar.service.CartService;
import vn.iotstar.service.impl.CartServiceImpl;

@WebServlet(urlPatterns = { "/admin/cart" })
public class AdminCartController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4758868079362696231L;
	CartService cartService = new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<CartModel> cartModel = cartService.getAllCart();
		req.setAttribute("allcart", cartModel);
		
		req.getRequestDispatcher("/views/admin/giohang.jsp").forward(req, resp);
	}
}
