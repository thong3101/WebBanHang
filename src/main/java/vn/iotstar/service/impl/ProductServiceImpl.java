package vn.iotstar.service.impl;

import java.sql.ResultSet;
import java.util.List;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDao productDAO = new ProductDaoImpl();
	
	@Override
	public List<ProductModel> getProductByUseridSeller(String sellerid) {
		// TODO Auto-generated method stub
		return productDAO.getProductByUseridSeller(sellerid);
	}

	@Override
	public void insert(ProductModel product) {
		// TODO Auto-generated method stub
		productDAO.insert(product);
	}

	@Override
	public void edit(ProductModel product) {
		// TODO Auto-generated method stub
		productDAO.edit(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productDAO.delete(id);
	}

	@Override
	public ProductModel get(int id) {
		// TODO Auto-generated method stub
		return productDAO.get(id);
	}

	@Override
	public List<CartItemModel> sanPhamOrder(String id) {
		// TODO Auto-generated method stub
		return productDAO.sanPhamOrder(id);
	}

	@Override
	public List<CartItemModel> Thongke(String id, String date) {
		// TODO Auto-generated method stub
		return productDAO.Thongke(id, date);
	}

	@Override
	public List<ResultSet> ThongKeSLBan(String userid) {
		// TODO Auto-generated method stub
		return productDAO.ThongKeSLBan(userid);
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBan(String id) {
		// TODO Auto-generated method stub
		return productDAO.ThongkeSLSanDaBan(id);
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBanTheoNgay(String id, String date) {
		// TODO Auto-generated method stub
		return productDAO.ThongkeSLSanDaBanTheoNgay(id, date);
	}

	@Override
	public int SoluongSP(int id) {
		// TODO Auto-generated method stub
		return productDAO.SoluongSP(id);
	}

	@Override
	public int SoluongHangcuaSP(int id) {
		// TODO Auto-generated method stub
		return productDAO.SoluongHangcuaSP(id);
	}

	@Override
	public int SoluongSPDangBan(int id) {
		// TODO Auto-generated method stub
		return productDAO.SoluongSPDangBan(id);
	}

	@Override
	public int SoluongSPDaBan(int id) {
		// TODO Auto-generated method stub
		return productDAO.SoluongSPDaBan(id);
	}

	@Override
	public List<ProductModel> getAllProduct(String typeProduce) {
		// TODO Auto-generated method stub
		return productDAO.getAllProduct(typeProduce);
	}

	@Override
	public List<ProductModel> get10Product() {
		// TODO Auto-generated method stub
		return productDAO.get10Product();
	}

	@Override
	public List<ProductModel> getAllProducteByCid(String cid, String typeProduce) {
		// TODO Auto-generated method stub
		return productDAO.getAllProducteByCid(cid, typeProduce);
	}

	@Override
	public List<ProductModel> getAllProductBySearch(String txtSearch) {
		// TODO Auto-generated method stub
		return productDAO.getAllProductBySearch(txtSearch);
	}

	@Override
	public ProductModel getProductByid(String pid) {
		// TODO Auto-generated method stub
		return productDAO.getProductByid(pid);
	}

	@Override
	public void updateSoluong(ProductModel product) {
		// TODO Auto-generated method stub
		productDAO.updateSoluong(product);
	}

	@Override
	public List<ProductModel> getAllProduct(String typeProduce, int index) {
		// TODO Auto-generated method stub
		return productDAO.getAllProduct(typeProduce, index);
	}

	@Override
	public List<ProductModel> getAllProducteByCid(String cid, String typeProduce, int index) {
		// TODO Auto-generated method stub
		return productDAO.getAllProducteByCid(cid, typeProduce, index);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return productDAO.countAll();
	}

	@Override
	public int countCid(String cid) {
		// TODO Auto-generated method stub
		return productDAO.countCid(cid);
	}

	@Override
	public int countProUid(String uid) {
		// TODO Auto-generated method stub
		return productDAO.countProUid(uid);
	}

}
