package vn.iotstar.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AcountModel;


@WebServlet(urlPatterns= {"/waiting"})
public class WaitingController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3708900754787041818L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(session !=null && session.getAttribute("acc")!=null) {
			AcountModel acount = (AcountModel) session.getAttribute("acc");
			req.setAttribute("user", acount.getUsername());
			if(acount.getIsAdmin()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin/home");
			}else if(acount.getIsSeller()==1) {
				resp.sendRedirect(req.getContextPath()+"/seller/home");
			}else {
				resp.sendRedirect(req.getContextPath()+"/home");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}
}
