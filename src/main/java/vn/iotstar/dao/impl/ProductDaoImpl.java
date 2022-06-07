package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.AcountModel;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.CartModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

public class ProductDaoImpl implements ProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	UserService userService = new UserServiceImpl();

	@Override
	public List<ProductModel> getProductByUseridSeller(String sellerid) {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product Where SellerID = ?";
		try {
			// má»Ÿ káº¿t ná»‘i database
			conn = new DBconnection().getConnection();
			// NĂ©m cĂ¢u query qua sql
			ps = conn.prepareStatement(sql);
			// gĂ¡n giĂ¡ trá»‹ cho dáº¥u há»�i
			ps.setString(1, sellerid);
			// cháº¡y query vĂ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			// láº¥y ResultSet Ä‘á»• vĂ o List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void insert(ProductModel product) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO product(ProductName,Description,Price,imageLink,CategoryID,SellerID,discount,Soluong,DaBan,status) VALUES (?,?,?,?,?,?,?,?,0,0)";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPdescription());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImageLink());
			ps.setInt(5, product.getCid());
			ps.setInt(6, product.getSellerid());
			ps.setInt(7, product.getDiscount());
			ps.setInt(8, product.getHangcon());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(ProductModel product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET ProductName=?, Description=?, Price=?, imageLink=?, CategoryID=?, discount=?, Soluong=?,status=? WHERE ProductID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPdescription());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImageLink());
			ps.setInt(5, product.getCid());
			ps.setInt(6, product.getDiscount());
			ps.setInt(7, product.getHangcon());
			ps.setInt(8, product.getStatus());
			ps.setInt(9, product.getPid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateSoluong(ProductModel product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET Soluong=?,DaBan=? WHERE ProductID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getHangcon());
			ps.setInt(2, product.getDaban());
			ps.setInt(3, product.getPid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product WHERE ProductID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProductModel get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product WHERE ProductID = ? ";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setPdescription(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setImageLink(rs.getString(5));
				product.setCid(rs.getInt(6));
				product.setSellerid(rs.getInt(7));
				product.setDiscount(rs.getInt(8));
				product.setHangcon(rs.getInt(9));
				product.setDaban(rs.getInt(10));
				product.setStatus(rs.getInt(11));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartItemModel> sanPhamOrder(String id) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "Select Cart.ID,UserID,date,ProductName,Price,quantity,discount from Cart,CartItem,Product where Cart.ID = CartItem.cat_id and Product.ProductID = CartItem.pro_id and CartItem.seller_id=?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AcountModel acount = userService.get(rs.getInt("UserID"));
				CartModel cart = new CartModel();
				cart.setId(rs.getString("ID"));
				cart.setBuyer(acount);
				cart.setBuyDate(rs.getDate("date"));

				ProductModel product = new ProductModel();
				product.setPname(rs.getString("ProductName"));
				product.setPrice(rs.getInt("Price"));
				product.setDiscount(rs.getInt("discount"));

				CartItemModel cartItem = new CartItemModel();

				cartItem.setCartid(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getInt("Price"));
				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartItemList;

	}

	@Override
	public List<CartItemModel> Thongke(String id, String date) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "Select Cart.ID,UserID,date,ProductName,Price,quantity,discount from Cart,CartItem,Product where Cart.ID = CartItem.cat_id and Product.ProductID = CartItem.pro_id and CartItem.seller_id=? and Cart.date=?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AcountModel acount = userService.get(rs.getInt("UserID"));
				CartModel cart = new CartModel();
				cart.setId(rs.getString("ID"));
				cart.setBuyer(acount);
				cart.setBuyDate(rs.getDate("date"));

				ProductModel product = new ProductModel();
				product.setPname(rs.getString("ProductName"));
				product.setPrice(rs.getInt("Price"));
				product.setDiscount(rs.getInt("discount"));

				CartItemModel cartItem = new CartItemModel();

				cartItem.setCartid(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getInt("Price"));
				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartItemList;

	}

	@Override
	public List<ResultSet> ThongKeSLBan(String id) {
		String sql = "Select sum(CartItem.quantity) as sl,Category.CategoryName from Category left join Product on Category.CategoryID=Product.CategoryID left join CartItem on CartItem.pro_id=Product.ProductID left join Cart on Cart.ID=CartItem.cat_id "
				+ "where CartItem.seller_id=? group by Category.CategoryID,Category.CategoryName";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ps.setString(1, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (List<ResultSet>) rs;
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBan(String id) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "Select ProductID,ProductName,sum(quantity) as sl from Cart,CartItem,Product where Cart.ID = CartItem.cat_id and Product.ProductID = CartItem.pro_id and CartItem.seller_id=? group by ProductName,ProductID";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AcountModel acount = userService.get(Integer.valueOf(id));
				CartModel cart = new CartModel();
				cart.setBuyer(acount);

				ProductModel product = new ProductModel();
				product.setPname(rs.getString("ProductName"));
				product.setPid(rs.getInt("ProductID"));
				
				CartItemModel cartItem = new CartItemModel();

				cartItem.setCartid(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("sl"));
				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartItemList;

	}

	public List<CartItemModel> ThongkeSLSanDaBanTheoNgay(String id, String date) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "Select ProductID,ProductName,sum(quantity) as sl from Cart,CartItem,Product where Cart.ID = CartItem.cat_id and Product.ProductID = CartItem.pro_id and CartItem.seller_id=? and Cart.date=? group by ProductName,ProductID";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AcountModel acount = userService.get(Integer.valueOf(id));
				CartModel cart = new CartModel();
				cart.setBuyer(acount);

				ProductModel product = new ProductModel();
				product.setPname(rs.getString("ProductName"));
				product.setPid(rs.getInt("ProductID"));
				
				
				CartItemModel cartItem = new CartItemModel();

				cartItem.setCartid(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("sl"));
				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartItemList;
	}

	public int SoluongSP(int id) {
		int sl = 0;
		String sql = "Select count(ProductID) from Product where SellerID=?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sl;
	}

	public int SoluongHangcuaSP(int id) {
		int sl = 0;
		String sql = "Select sum(Soluong) from Product where SellerID=?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sl;

	}

	public int SoluongSPDangBan(int id) {
		int sl = 0;
		String sql = "Select count(ProductID) from Product where SellerID=? and status=1";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sl;

	}

	public int SoluongSPDaBan(int id) {
		int sl = 0;
		String sql = "Select sum(DaBan) from Product where SellerID=?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sl;

	}

	@Override
	public List<ProductModel> getAllProduct(String typeProduce) {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String orderBy = " ORDER BY ";

		if ("0".equals(typeProduce)) {

			orderBy = orderBy + "Soluong DESC";
		} else if ("1".equals(typeProduce)) {
			orderBy = orderBy + "ProductID DESC";
		} else if ("2".equals(typeProduce)) {
			orderBy = orderBy + "DaBan DESC";
		} else if ("3".equals(typeProduce)) {
			orderBy = orderBy + "Price";
		} else {
			orderBy = orderBy + "Price DESC";
		}

		String sql = "select * from Product where status=1 ";
		sql = sql + orderBy;
		try {
			// má»Ÿ káº¿t ná»‘i database
			conn = new DBconnection().getConnection();
			// NĂ©m cĂ¢u query qua sql
			ps = conn.prepareStatement(sql);
			// cháº¡y query vĂ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			// láº¥y ResultSet Ä‘á»• vĂ o List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	@Override
	public List<ProductModel> get10Product() {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select top 10 * from Product and status=1";
		try {
			// má»Ÿ káº¿t ná»‘i database
			conn = new DBconnection().getConnection();
			// NĂ©m cĂ¢u query qua sql
			ps = conn.prepareStatement(sql);
			// cháº¡y query vĂ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			// láº¥y ResultSet Ä‘á»• vĂ o List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getAllProducteByCid(String cid, String typeProduce) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String orderBy = "ORDER BY ";

		if ("0".equals(typeProduce)) {

			orderBy = orderBy + "Soluong DESC";
		} else if ("1".equals(typeProduce)) {
			orderBy = orderBy + "ProductID DESC";
		} else if ("2".equals(typeProduce)) {
			orderBy = orderBy + "DaBan DESC";
		} else if ("3".equals(typeProduce)) {
			orderBy = orderBy + "Price";
		} else {
			orderBy = orderBy + "Price DESC";
		}

		String sql = "select * from Product where CategoryID = ? and status=1 ";
		sql = sql + orderBy;

		try {
			// má»Ÿ káº¿t ná»‘i database
			conn = new DBconnection().getConnection();
			// NĂ©m cĂ¢u query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
//			ps.setString(2, orderBy);
			// cháº¡y query vĂ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			// láº¥y ResultSet Ä‘á»• vĂ o List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getAllProductBySearch(String txtSearch) {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();

		String sql = "select * from Product where ProductName like \'%" + txtSearch + "%\' and status=1 ";

		try {
			// má»Ÿ káº¿t ná»‘i database
			conn = new DBconnection().getConnection();
			// NĂ©m cĂ¢u query qua sql
			ps = conn.prepareStatement(sql);
			// cháº¡y query vĂ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			// láº¥y ResultSet Ä‘á»• vĂ o List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ProductModel getProductByid(String pid) {

		String sql = "select * from Product where ProductID = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	@Override
	public List<ProductModel> getAllProduct(String typeProduce, int index) {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String orderBy = " ORDER BY ";

		if ("0".equals(typeProduce)) {

			orderBy = orderBy + "Soluong DESC";
		} else if ("1".equals(typeProduce)) {
			orderBy = orderBy + "ProductID DESC";
		} else if ("2".equals(typeProduce)) {
			orderBy = orderBy + "DaBan DESC";
		} else if ("3".equals(typeProduce)) {
			orderBy = orderBy + "Price";
		} else {
			orderBy = orderBy + "Price DESC";
		}

		String sql = "select * from Product where status=1" + orderBy + ",status OFFSET ? ROW fetch next 10 rows only";
		try {
			// má»Ÿ káº¿t ná»‘i database
			conn = new DBconnection().getConnection();
			// NĂ©m cĂ¢u query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 10);
			// cháº¡y query vĂ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			// láº¥y ResultSet Ä‘á»• vĂ o List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	@Override
	public List<ProductModel> getAllProducteByCid(String cid, String typeProduce, int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String orderBy = "ORDER BY ";

		if ("0".equals(typeProduce)) {

			orderBy = orderBy + "Soluong DESC";
		} else if ("1".equals(typeProduce)) {
			orderBy = orderBy + "ProductID DESC";
		} else if ("2".equals(typeProduce)) {
			orderBy = orderBy + "DaBan DESC";
		} else if ("3".equals(typeProduce)) {
			orderBy = orderBy + "Price";
		} else {
			orderBy = orderBy + "Price DESC";
		}

		String sql = "select * from Product where CategoryID = ? and status=1" + orderBy
				+ ",status OFFSET ? ROW fetch next 10 rows only";

		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			ps.setInt(2, (index - 1) * 10);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int countAll() {
		String query = "SELECT count(*) FROM Product where status=1";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int countCid(String cid) {
		String query = "SELECT count(*) FROM Product where CategoryID = ? and status=1";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@Override
	public int countProUid(String uid) {
		String query = "SELECT count(*) FROM Product where SellerID=?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
