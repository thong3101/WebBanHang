package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.AcountModel;

public interface UserDao {
	void edit(AcountModel acount);
	void eidtPass(AcountModel acount);
	public AcountModel get(int id);
	List<AcountModel> getAllUser();
	void delete(int uid);
	void editAdmin(AcountModel acount);
}
