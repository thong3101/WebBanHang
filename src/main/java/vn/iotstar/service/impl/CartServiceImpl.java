package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.CartDao;
import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.model.CartModel;
import vn.iotstar.service.CartService;

public class CartServiceImpl implements CartService{
	CartDao cartDao = new CartDaoImpl();
	@Override
	public void insert(CartModel cart) {
		// TODO Auto-generated method stub
		cartDao.insert(cart);
	}
	@Override
	public CartModel getCart(String id) {
		// TODO Auto-generated method stub
		return cartDao.getCart(id);
	}
	@Override
	public List<CartModel> getAllCart() {
		// TODO Auto-generated method stub
		return cartDao.getAllCart();
	}

}
