package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.BillModel;

public interface BillDao {

	void insert(BillModel order);


	BillModel get(String id);



	List<BillModel> getModelByUserid(int id);

}
