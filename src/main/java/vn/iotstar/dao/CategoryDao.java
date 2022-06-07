package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryDao {
	public List<CategoryModel> getAllCategory();

	CategoryModel get(String name);
	public CategoryModel insert(CategoryModel category);

	CategoryModel getProductCateByid(String cid);

	void delete(int id);

	CategoryModel edit(CategoryModel category);
}
