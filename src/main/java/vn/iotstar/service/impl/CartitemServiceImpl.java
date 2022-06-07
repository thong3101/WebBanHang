package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.CartitemDao;
import vn.iotstar.dao.impl.CartitemDaoImpl;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.service.CartitemService;

public class CartitemServiceImpl implements CartitemService{
	CartitemDao cartitemDao = new CartitemDaoImpl();
	@Override
	public void insert(CartItemModel cartItem) {
		// TODO Auto-generated method stub
		cartitemDao.insert(cartItem);
	}
	@Override
	public List<CartItemModel> getAllCartItem(String id) {
		// TODO Auto-generated method stub
		return cartitemDao.getAllCartItem(id);
	}

}
