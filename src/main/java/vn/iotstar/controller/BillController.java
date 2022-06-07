package vn.iotstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.BillModel;
import vn.iotstar.service.BillService;
import vn.iotstar.service.impl.BillServiceImpl;

@WebServlet(urlPatterns = { "/bill" }) 
public class BillController extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = 4154556314010880548L;
	BillService billService = new BillServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String cartid = req.getParameter("cartid");
		
		BillModel bill = billService.get(cartid);
		req.setAttribute("bill", bill);
		
		
		req.getRequestDispatcher("/views/bill.jsp").forward(req, resp);
	}
}
