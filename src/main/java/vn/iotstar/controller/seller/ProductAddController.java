package vn.iotstar.controller.seller;

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
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.util.Constant;


@WebServlet(urlPatterns = { "/seller/product/add" })
public class ProductAddController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7928899603315081437L;
	CategoryService categoryService = new CategoryServiceImpl();
	ProductService proService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		
		List<CategoryModel> listCate = categoryService.getAllCategory();
		req.setAttribute("listCategory", listCate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/seller/seller-product-add.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		AcountModel a = (AcountModel) session.getAttribute("acc");
		
		
		ProductModel product = new ProductModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			product.setSellerid(a.getUid());
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setPname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("imageLink")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);
						product.setImageLink("product/" + fileName);
					} else {
						product.setImageLink(null);
					}
				} else if(item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString()));
				} else if(item.getFieldName().equals("description")) {
					product.setPdescription(item.getString("UTF-8"));
				} else if(item.getFieldName().equals("hangcon")) {
					product.setHangcon(Integer.parseInt(item.getString()));
				} else if(item.getFieldName().equals("category")) {
					product.setCid(Integer.parseInt(item.getString()));
				} else if(item.getFieldName().equals("discount")) {
					product.setDiscount(Integer.parseInt(item.getString()));
				} 			
			}
			proService.insert(product);
			resp.sendRedirect(req.getContextPath() + "/seller/product/list?userid="+ a.getUid());
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
