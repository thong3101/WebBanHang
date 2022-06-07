package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.BillDao;
import vn.iotstar.model.BillModel;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.CartModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CartService;
import vn.iotstar.service.impl.CartServiceImpl;



public class BillDaoImpl implements BillDao{
	CartService cartS = new CartServiceImpl();
	Connection conn= null;

	PreparedStatement ps = null;

	ResultSet rs = null;
	
	@Override
	public void insert(BillModel bill) {
		// TODO Auto-generated method stub
		String sql = "insert into bill(cart, Name, diachi, sodienthoai,email,ship_price,subtotal,payment) values(?,?,?,?,?,?,?,?)";

		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bill.getCart().getId());
			ps.setString(2, bill.getOrderName());
			ps.setString(3, bill.getOrderAddress());
			ps.setString(4, bill.getOrderPhone());
			ps.setString(5, bill.getOrderEmail());
			ps.setInt(6, bill.getShipprice());
			ps.setInt(7, bill.getSubtotal());
			ps.setString(8, bill.getPayment());
			ps.executeUpdate();

		}catch(Exception e) {

			e.printStackTrace();

		}
	}
	
	@Override
	public BillModel get(String id) {
		String sql = "SELECT * FROM bill WHERE cart = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillModel bill = new BillModel();
				bill.setId(rs.getInt(1));
				CartModel cartModel = cartS.getCart(rs.getString(2));
				bill.setCart(cartModel);
				bill.setOrderName(rs.getString(3));
				bill.setOrderAddress(rs.getString(4));
				bill.setOrderPhone(rs.getString(5));
				bill.setOrderEmail(rs.getString(6));
				bill.setShipprice(rs.getInt(7));
				bill.setSubtotal(rs.getInt(8));
				bill.setPayment(rs.getString(9));
				return bill;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<BillModel> getModelByUserid(int id) {
		List<BillModel> billList = new ArrayList<BillModel>();
		String sql = "select bill.id,cart,Name,diachi,sodienthoai,email,ship_price,subtotal,payment from bill,Cart where bill.cart=cart.ID and cart.UserID=?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillModel bill = new BillModel();
				bill.setId(rs.getInt(1));
				CartModel cartModel = cartS.getCart(rs.getString(2));
				bill.setCart(cartModel);
				bill.setOrderName(rs.getString(3));
				bill.setOrderAddress(rs.getString(4));
				bill.setOrderPhone(rs.getString(5));
				bill.setOrderEmail(rs.getString(6));
				bill.setShipprice(rs.getInt(7));
				bill.setSubtotal(rs.getInt(8));
				bill.setPayment(rs.getString(9));
				
				billList.add(bill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billList;
	}
}
