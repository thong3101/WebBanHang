package vn.iotstar.dao;

import vn.iotstar.model.AcountModel;

public interface LoginDao {
	AcountModel login(String user, String pass);
	public AcountModel checkAcc(String user);
	public void signup(AcountModel acount);
}
