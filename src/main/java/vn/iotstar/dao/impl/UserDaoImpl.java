package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AcountModel;


public class UserDaoImpl implements UserDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void edit(AcountModel acount) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET Name=?, Phone=?, Address=?, Email=?, Anh=? WHERE UserID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acount.getFullName());
			ps.setString(2, acount.getPhone());
			ps.setString(3, acount.getAddress());
			ps.setString(4, acount.getEmail());
			ps.setString(5, acount.getAnh());
			ps.setInt(6, acount.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eidtPass(AcountModel acount) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET Password=? WHERE UserID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acount.getPassword());
			ps.setInt(2, acount.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public AcountModel get(int id) {
		String sql = "SELECT * FROM Users WHERE UserID = ?";
	
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				AcountModel user = new AcountModel();
				user.setUid(rs.getInt("UserID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setFullName(rs.getString("Name"));
				user.setPhone(rs.getString("Phone"));
				user.setAddress(rs.getString("Address"));
				user.setEmail(rs.getString("Email"));
				user.setIsSeller(rs.getInt("isSeller"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setAnh(rs.getString("Anh"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<AcountModel> getAllUser() {
		List<AcountModel> listuser = new ArrayList<AcountModel>();
		String sql = "SELECT * FROM Users WHERE isAdmin=0";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AcountModel user = new AcountModel();
				user.setUid(rs.getInt("UserID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setFullName(rs.getString("Name"));
				user.setPhone(rs.getString("Phone"));
				user.setAddress(rs.getString("Address"));
				user.setEmail(rs.getString("Email"));
				user.setIsSeller(rs.getInt("isSeller"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setAnh(rs.getString("Anh"));
				
				listuser.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listuser;
	}
	@Override
	public void delete(int uid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM users WHERE UserID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void editAdmin(AcountModel acount) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET Name=?, Phone=?, Address=?, Email=?,isSeller=?, Anh=? WHERE UserID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acount.getFullName());
			ps.setString(2, acount.getPhone());
			ps.setString(3, acount.getAddress());
			ps.setString(4, acount.getEmail());
			ps.setInt(5,acount.getIsSeller());
			ps.setString(6, acount.getAnh());
			ps.setInt(7, acount.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
