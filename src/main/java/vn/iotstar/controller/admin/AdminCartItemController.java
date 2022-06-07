package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CartItemModel;
import vn.iotstar.service.CartitemService;
import vn.iotstar.service.impl.CartitemServiceImpl;

@WebServlet(urlPatterns = { "/admin/cartitem" })
public class AdminCartItemController extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -3112224286607499058L;
	CartitemService cartitemService = new CartitemServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String cartid = req.getParameter("cartid");
		List<CartItemModel> allcartitem = cartitemService.getAllCartItem(cartid);
		req.setAttribute("allcartitem", allcartitem);
		
		req.getRequestDispatcher("/views/admin/cartitem.jsp").forward(req, resp);
	}
}
