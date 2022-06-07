package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CartModel;

public interface CartService {
	void insert(CartModel cart);
	
	CartModel getCart(String id);
	
	List<CartModel> getAllCart();
}
