package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.AcountModel;


public interface UserService {
	void edit(AcountModel acount);
	void eidtPass(AcountModel acount);
	public AcountModel get(int id);
	List<AcountModel> getAllUser();
	void delete(int uid);
	void editAdmin(AcountModel acount);
}
