package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CartModel;

public interface CartDao {

	void insert(CartModel cart);

	CartModel getCart(String id);

	List<CartModel> getAllCart();

}
