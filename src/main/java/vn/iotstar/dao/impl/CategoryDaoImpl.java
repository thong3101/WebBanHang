package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnection;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.model.CategoryModel;

public class CategoryDaoImpl implements CategoryDao{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<CategoryModel> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "Select * From Category";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CategoryModel(rs.getInt(1),rs.getString(2)));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category WHERE CategoryName = ? ";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCid(rs.getInt(1));
				category.setCname(rs.getString(2));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public CategoryModel insert(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO category(CategoryName) VALUES (?)";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.executeUpdate();
			
			while(rs.next())
			{
				return new CategoryModel(rs.getInt(1), rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;

	}
	
	@Override
	public CategoryModel getProductCateByid(String cid) {
		// TODO Auto-generated method stub
		String query = "Select * from category where CategoryID = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while(rs.next())
			{
				return new CategoryModel(rs.getInt(1), rs.getString(2));
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM category WHERE CategoryID = ?";
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
	public CategoryModel edit(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "UPDATE category SET CategoryName = ? WHERE CategoryID = ?";
		try {
			conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.setInt(2, category.getCid());
			ps.executeUpdate();
			
			while(rs.next())
			{
				return new CategoryModel(rs.getInt(1), rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;	
	}
	

}
