package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CartItemModel;

public interface CartitemService {
	void insert(CartItemModel cartItem);
	List<CartItemModel> getAllCartItem(String id);
}
