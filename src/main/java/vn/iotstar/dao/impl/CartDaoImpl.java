package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.CartDao;
import vn.iotstar.model.CartModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

public class CartDaoImpl extends DBconnection implements CartDao{
	UserService userService = new UserServiceImpl();
	
	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO Cart(ID,UserID,total, date) VALUES (?,?,?,?)";
		
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart.getId());
			ps.setInt(2, cart.getBuyer().getUid());
			ps.setFloat(3, cart.getTotal());
			ps.setDate(4, new Date(cart.getBuyDate().getTime()));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public CartModel getCart(String id) {
		String sql = "Select * from Cart where ID=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getString(1));
				cart.setBuyer( userService.get(rs.getInt(2)) );
				cart.setTotal(rs.getFloat(3));
				cart.setBuyDate( rs.getDate(4) );
				return cart;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CartModel> getAllCart() {
		List<CartModel> listcart = new ArrayList<CartModel>();
		String sql = "Select * from Cart";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getString(1));
				cart.setBuyer( userService.get(rs.getInt(2)) );
				cart.setTotal(rs.getFloat(3));
				cart.setBuyDate( rs.getDate(4) );
				
				listcart.add(cart);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listcart;
	}
}
