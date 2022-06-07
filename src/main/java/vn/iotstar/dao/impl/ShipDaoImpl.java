package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.ShipDao;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.CityModel;
import vn.iotstar.model.PaymentModel;

public class ShipDaoImpl implements ShipDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<CityModel> getShip() {
		// TODO Auto-generated method stub
		List<CityModel> list = new ArrayList<CityModel>();
		String sql = "Select * From Ship";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CityModel(rs.getString(1),rs.getInt(2)));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	@Override
	public List<PaymentModel> get() {
		// TODO Auto-generated method stub
		List<PaymentModel> list = new ArrayList<PaymentModel>();
		String sql = "Select * From Payment";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new PaymentModel(rs.getInt(1),rs.getString(2)));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
