package vn.iotstar.service;

import vn.iotstar.model.AcountModel;

public interface LoginService {
	AcountModel login(String user, String pass);
	public AcountModel checkAcc(String user);
	public void signup(AcountModel acount);
	
	
}
