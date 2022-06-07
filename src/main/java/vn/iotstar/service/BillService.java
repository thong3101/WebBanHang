package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.BillModel;

public interface BillService {
	void insert(BillModel order);
	
	BillModel get(String id);
	
	List<BillModel> getModelByUserid(int id);
}
