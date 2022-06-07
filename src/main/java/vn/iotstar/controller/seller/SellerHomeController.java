package vn.iotstar.controller.seller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/seller/home" })
public class SellerHomeController extends HttpServlet {


	private static final long serialVersionUID = 8166082184979592497L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		ProductService productService = new ProductServiceImpl();
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		
		
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        Date date1 = new Date();
        String strDate1 = formatter.format(date1);
        
        
        int slhang = productService.SoluongHangcuaSP(a.getUid());
        int sl = productService.SoluongSP(a.getUid());
        int sldangban = productService.SoluongSPDangBan(a.getUid());
        int sldaban = productService.SoluongSPDaBan(a.getUid());
        
        req.setAttribute("date", strDate);
        req.setAttribute("date1", strDate1);
        req.setAttribute("soluongsp", sl);
        req.setAttribute("soluonghang", slhang);
        req.setAttribute("soluongspdangban", sldangban);
        req.setAttribute("soluongspdaban", sldaban);
        
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/seller-home.jsp");
		dispatcher.forward(req, resp);
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        System.out.print(strDate);
	}
}
