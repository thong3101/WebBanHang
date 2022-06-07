package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.ShipDao;
import vn.iotstar.dao.impl.ShipDaoImpl;
import vn.iotstar.model.CityModel;
import vn.iotstar.model.PaymentModel;
import vn.iotstar.service.ShipService;

public class ShipServiceImpl implements ShipService{

	ShipDao shipDao = new ShipDaoImpl();
	@Override
	public List<CityModel> getShip() {
		// TODO Auto-generated method stub
		return shipDao.getShip();
	}
	@Override
	public List<PaymentModel> get() {
		// TODO Auto-generated method stub
		return shipDao.get();
	}

}
