package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CityModel;
import vn.iotstar.model.PaymentModel;

public interface ShipService {
	List<CityModel> getShip();
	
	List<PaymentModel> get();
}
