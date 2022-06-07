package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.CartitemDao;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.CartModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CartService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.CartServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.service.impl.UserServiceImpl;

public class CartitemDaoImpl extends DBconnection implements CartitemDao{
	CartService cartService = new CartServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserService userService = new UserServiceImpl();
	
	@Override
	public void insert(CartItemModel cartItem) {
		String sql = "INSERT INTO CartItem(quantity,unitPrice,pro_id,cat_id,seller_id) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getQuantity());
			ps.setFloat(2, cartItem.getUnitPrice());
			ps.setInt(3, cartItem.getProduct().getPid());
			ps.setString(4, cartItem.getCartid().getId());
			ps.setInt(5, cartItem.getProduct().getSellerid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<CartItemModel> getAllCartItem(String id) {
		List<CartItemModel> listcartitem = new ArrayList<CartItemModel>();
		String sql = "Select * from CartItem where cat_id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = cartService.getCart(rs.getString(5));
				
				ProductModel product = productService.get(rs.getInt(4));
				
				CartItemModel cartItem = new CartItemModel();
				cartItem.setQuantity(rs.getInt(2));
				cartItem.setUnitPrice(rs.getInt(3));
				cartItem.setProduct(product);
				cartItem.setCartid(cart);
				cartItem.setSellerid(rs.getInt(6));
				
				
				listcartitem.add(cartItem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listcartitem;
	}
}
