package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	CategoryDao categoryDAO = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategory();
	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return categoryDAO.get(name);
	}

	@Override
	public CategoryModel insert(CategoryModel category) {
		// TODO Auto-generated method stub
		return categoryDAO.insert(category);
	}

	@Override
	public CategoryModel getProductCateByid(String cid) {
		// TODO Auto-generated method stub
		return categoryDAO.getProductCateByid(cid);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDAO.delete(id);
	}

	@Override
	public CategoryModel edit(CategoryModel category) {
		// TODO Auto-generated method stub
		return categoryDAO.edit(category);
	}

}
