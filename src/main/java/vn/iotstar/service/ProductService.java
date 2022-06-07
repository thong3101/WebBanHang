package vn.iotstar.service;

import java.sql.ResultSet;
import java.util.List;

import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.ProductModel;


public interface ProductService {
	List<ProductModel> getProductByUseridSeller(String sellerid);
	
	void insert(ProductModel product);
	void edit(ProductModel product);
	void delete(int id);
	ProductModel get(int id);
	public List<CartItemModel> sanPhamOrder(String id);
	public List<CartItemModel> Thongke(String id,String date);

	
	List<ResultSet> ThongKeSLBan(String userid);
	public List<CartItemModel> ThongkeSLSanDaBan(String id);
	public List<CartItemModel> ThongkeSLSanDaBanTheoNgay(String id,String date);
	public int SoluongSP(int id);
	public int SoluongHangcuaSP(int id);
	public int SoluongSPDangBan(int id);
	public int SoluongSPDaBan(int id);
	
	
	List<ProductModel> getAllProduct(String typeProduce);

	List<ProductModel> get10Product();

	List<ProductModel> getAllProducteByCid(String cid, String typeProduce);

	List<ProductModel> getAllProductBySearch(String txtSearch);
	
	ProductModel getProductByid(String pid);
	
	void updateSoluong(ProductModel product);
	
	
	List<ProductModel> getAllProduct(String typeProduce, int index);
	List<ProductModel> getAllProducteByCid(String cid, String typeProduce, int index);
	int countAll();
	int countCid(String cid);
	int countProUid(String uid);
}
