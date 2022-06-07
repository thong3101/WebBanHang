package vn.iotstar.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;
import vn.iotstar.model.BillModel;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.CartModel;
import vn.iotstar.model.CityModel;
import vn.iotstar.model.PaymentModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.BillService;
import vn.iotstar.service.CartService;
import vn.iotstar.service.CartitemService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.ShipService;
import vn.iotstar.service.impl.BillServiceImpl;
import vn.iotstar.service.impl.CartServiceImpl;
import vn.iotstar.service.impl.CartitemServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.service.impl.ShipServiceImpl;

@WebServlet(urlPatterns = { "/checkout" }) 
public class CheckoutController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7750109750888546749L;
	ShipService shipService = new ShipServiceImpl();
	ProductService productService = new ProductServiceImpl();
	
	CartService cartServire = new CartServiceImpl();
	CartitemService cartItemServire = new CartitemServiceImpl();
	BillService billService = new BillServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		
		
		if(a==null) {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
		else {
			List<CityModel> cityship = shipService.getShip();
			req.setAttribute("cityship", cityship);
			
			List<PaymentModel> payment = shipService.get();
			req.setAttribute("payment", payment);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/checkout.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String name=req.getParameter("fname");
		String ship=req.getParameter("shipprice");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		
		String tongtienchuatinship=req.getParameter("tongtiensp");
		String payment=req.getParameter("optradio");
		
		System.out.println(payment);

		Date date = new Date();

		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		AcountModel users = (AcountModel) httpSession.getAttribute("acc");
		
		try {
			long ID = new Date().getTime();
			CartModel cartModel = new CartModel();
			cartModel.setId(String.valueOf(ID));
			cartModel.setBuyer(users);
			cartModel.setTotal(Integer.parseInt(tongtienchuatinship));
			cartModel.setBuyDate(date);
			cartServire.insert(cartModel);

			

			Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) cart;
			for (Entry<Integer, CartItemModel> item : map.entrySet()) {
				cartItemServire.insert(new CartItemModel(item.getValue().getId(),item.getValue().getQuantity() ,
						item.getValue().getUnitPrice(),item.getValue().getProduct(),cartModel,item.getValue().getProduct().getSellerid()));
				
				ProductModel product = new ProductModel();
				product.setPid(item.getValue().getProduct().getPid());
				product.setHangcon(item.getValue().getProduct().getHangcon()-item.getValue().getQuantity());
				product.setDaban(item.getValue().getProduct().getDaban()+item.getValue().getQuantity());
				productService.updateSoluong(product);
			}
			
			BillModel bill = new BillModel();
			bill.setCart(cartModel);
			bill.setOrderName(name);
			bill.setOrderAddress(address);
			bill.setOrderPhone(phone);
			bill.setOrderEmail(email);
			bill.setShipprice(Integer.parseInt(ship));
			bill.setSubtotal(Integer.parseInt(tongtienchuatinship)+Integer.parseInt(ship));
			bill.setPayment(payment);
			billService.insert(bill);
			
			
			httpSession.removeAttribute("cart");
			resp.sendRedirect(req.getContextPath() + "/bill?cartid="+ID);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		/*System.out.println(name);
		System.out.println(ship);
		System.out.println(address);
		System.out.println(phone);
		System.out.println(email);
		
		System.out.println(tong);
		System.out.println(payment);*/
	}
}
