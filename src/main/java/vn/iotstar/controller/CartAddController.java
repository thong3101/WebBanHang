package vn.iotstar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/cart-add" })
public class CartAddController extends HttpServlet{
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 8770073412001701140L;
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String pId = req.getParameter("pId");
		String quantity = req.getParameter("quantity");
		
		ProductModel product = productService.getProductByid(pId);
		
		CartItemModel cartItem = new CartItemModel();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);
		
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		
		if (obj == null) {
			Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
			map.put(cartItem.getProduct().getPid(), cartItem);
			httpSession.setAttribute("cart", map);
		} else {
			Map<Integer, CartItemModel> map = extracted(obj);
			CartItemModel existedCartItem = map.get(Integer.valueOf(pId));
			if (existedCartItem == null) {
				map.put(product.getPid(), cartItem);
			} else {
				existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
			}

			httpSession.setAttribute("cart", map);
		}
		
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
	
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}
