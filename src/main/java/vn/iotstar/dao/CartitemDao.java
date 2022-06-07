package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CartItemModel;

public interface CartitemDao {

	void insert(CartItemModel cartItem);

	List<CartItemModel> getAllCartItem(String id);

}
