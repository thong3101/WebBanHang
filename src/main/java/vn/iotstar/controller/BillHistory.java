package vn.iotstar.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;
import vn.iotstar.model.BillModel;
import vn.iotstar.service.BillService;
import vn.iotstar.service.impl.BillServiceImpl;

@WebServlet(urlPatterns = { "/bill-list" }) 
public class BillHistory extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2965408503754272462L;
	BillService billService = new BillServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		
		List<BillModel> listBill = billService.getModelByUserid(a.getUid());
		
		req.setAttribute("listbill", listBill);
		
		req.getRequestDispatcher("/views/donhang.jsp").forward(req, resp);
	}
}
