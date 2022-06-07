package vn.iotstar.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/seller/product/delete" })
public class ProductDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8238112095381837976L;
	ProductService prService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		prService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/seller/product/list?userid="+ a.getUid());
	}
}
