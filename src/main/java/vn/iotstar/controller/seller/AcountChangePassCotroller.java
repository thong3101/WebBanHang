package vn.iotstar.controller.seller;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vn.iotstar.model.AcountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = { "/seller/change-pass" })
public class AcountChangePassCotroller extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 3608433350711999876L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/change-password.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");


		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String currentpass = req.getParameter("currentpass");
		String newpass = req.getParameter("newpass");
		String retypepass = req.getParameter("retype");
		
		if(currentpass.isEmpty() || newpass.isEmpty() || retypepass.isEmpty()) {
			req.setAttribute("mess", "Nhập đủ thông tin");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/change-password.jsp");
			dispatcher.forward(req, resp);
		}
		else if(a.getPassword().equals(currentpass)) {
			if(newpass.equals(retypepass)) {
				a.setPassword(newpass);
				userService.eidtPass(a);
				resp.sendRedirect(req.getContextPath() + "/seller/acount?userid=" + a.getUid());
			} else {
				req.setAttribute("mess", "Nhập lại password không khớp với password mới");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/change-password.jsp");
				dispatcher.forward(req, resp);
			}
		}else {
			req.setAttribute("mess", "Password không đúng");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/change-password.jsp");
			dispatcher.forward(req, resp);
		}
		
		
	}
}
