package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.LoginDao;
import vn.iotstar.model.AcountModel;

public class LoginDaoImpl implements LoginDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public AcountModel login(String user, String pass) {
		// TODO Auto-generated method stub
		String sql = "Select * from Users where Username=? and Password=?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new AcountModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public AcountModel checkAcc(String user) {
		String sql = "Select * from Users where Username=?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new AcountModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public void signup(AcountModel acount) {
		String sql = "INSERT INTO Users(UserName,Password,Name,Phone,Address,Email,isSeller,isAdmin) VALUES (?,?,?,?,?,?,?,0)";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acount.getUsername());
			ps.setString(2, acount.getPassword());
			ps.setString(3, acount.getFullName());
			ps.setString(4, acount.getPhone());
			ps.setString(5, acount.getAddress());
			ps.setString(6, acount.getEmail());
			ps.setInt(7, acount.getIsSeller());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
