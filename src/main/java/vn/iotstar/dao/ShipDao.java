package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.CityModel;
import vn.iotstar.model.PaymentModel;

public interface ShipDao {

	List<CityModel> getShip();

	List<PaymentModel> get();

}
