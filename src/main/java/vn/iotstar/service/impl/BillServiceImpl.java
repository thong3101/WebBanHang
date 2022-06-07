package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.BillDao;
import vn.iotstar.dao.impl.BillDaoImpl;
import vn.iotstar.model.BillModel;
import vn.iotstar.service.BillService;

public class BillServiceImpl implements BillService{
	BillDao billDao = new BillDaoImpl();
	@Override
	public void insert(BillModel order) {
		// TODO Auto-generated method stub
		billDao.insert(order);
	}
	@Override
	public BillModel get(String id) {
		// TODO Auto-generated method stub
		return billDao.get(id);
	}
	@Override
	public List<BillModel> getModelByUserid(int id) {
		// TODO Auto-generated method stub
		return billDao.getModelByUserid(id);
	}

}
