package vn.iotstar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.model.AcountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/admin/acount" })
public class AcountAdminController extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4462073479277792132L;
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin-acount.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					a.setFullName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("anh")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/admin/" + fileName);
						item.write(file);
						a.setAnh("admin/" + fileName);
					} else {
						a.setAnh(null);
					}
				} else if(item.getFieldName().equals("address")) {
					a.setAddress(item.getString("UTF-8"));
				} else if(item.getFieldName().equals("phone")) {
					a.setPhone(item.getString());
				} else if(item.getFieldName().equals("seller")) {
					a.setIsSeller(Integer.parseInt(item.getString()));
				} else if(item.getFieldName().equals("email")) {
					a.setEmail(item.getString());
				}
			}
			userService.editAdmin(a);
			resp.sendRedirect(req.getContextPath() + "/admin/acount?userid="+ a.getUid());
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
