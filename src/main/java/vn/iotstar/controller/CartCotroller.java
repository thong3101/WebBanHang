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
import vn.iotstar.model.CityModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ShipService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ShipServiceImpl;

@WebServlet(urlPatterns = { "/cart" })
public class CartCotroller extends HttpServlet{




	/**
	 * 
	 */
	private static final long serialVersionUID = 2907689532094749153L;
	CategoryService cateService = new CategoryServiceImpl();
	ShipService shipService = new ShipServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		List<CategoryModel> listC = cateService.getAllCategory();
		req.setAttribute("listCategory", listC);
		
		List<CityModel> cityship = shipService.getShip();
		req.setAttribute("cityship", cityship);
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/cart-list.jsp");
		dispatcher.forward(req, resp);
	}
}
