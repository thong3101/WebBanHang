package vn.iotstar.service.impl;

import vn.iotstar.dao.LoginDao;
import vn.iotstar.dao.impl.LoginDaoImpl;
import vn.iotstar.model.AcountModel;
import vn.iotstar.service.LoginService;

public class LoginServiceImpl implements LoginService{

	LoginDao loginDAO = new LoginDaoImpl();
	@Override
	public AcountModel login(String user, String pass) {
		// TODO Auto-generated method stub
		return loginDAO.login(user, pass);
	}
	@Override
	public AcountModel checkAcc(String user) {
		// TODO Auto-generated method stub
		return loginDAO.checkAcc(user);
	}
	@Override
	public void signup(AcountModel acount) {
		// TODO Auto-generated method stub
		loginDAO.signup(acount);
	}

}
