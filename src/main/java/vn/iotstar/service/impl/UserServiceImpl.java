package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.AcountModel;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService{

	
	UserDao UserDao = new UserDaoImpl();
	@Override
	public void edit(AcountModel acount) {
		// TODO Auto-generated method stub
		UserDao.edit(acount);
	}
	@Override
	public void eidtPass(AcountModel acount) {
		// TODO Auto-generated method stub
		UserDao.eidtPass(acount);
	}
	@Override
	public AcountModel get(int id) {
		// TODO Auto-generated method stub
		return UserDao.get(id);
	}
	@Override
	public List<AcountModel> getAllUser() {
		// TODO Auto-generated method stub
		return UserDao.getAllUser();
	}
	@Override
	public void delete(int uid) {
		// TODO Auto-generated method stub
		UserDao.delete(uid);
	}
	@Override
	public void editAdmin(AcountModel acount) {
		// TODO Auto-generated method stub
		UserDao.editAdmin(acount);
	}
	
}
