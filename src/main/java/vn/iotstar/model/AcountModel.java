package vn.iotstar.model;

public class AcountModel {
	private int uid;
	private String username;
	private String password;
	private String FullName;
	private String Phone;
	private String Address;
	private String Email;
	private int isSeller;
	private int isAdmin;
	private String Anh;
	
	
	
	@Override
	public String toString() {
		return "AcountModel [uid=" + uid + ", username=" + username + ", password=" + password + ", FullName="
				+ FullName + ", Phone=" + Phone + ", Address=" + Address + ", Email=" + Email + ", isSeller=" + isSeller
				+ ", isAdmin=" + isAdmin + ", Anh=" + Anh + "]";
	}
	public AcountModel() {
		super();
	}
	public AcountModel(int uid, String username, String password, String fullName, String phone, String address,
			String email, int isSeller, int isAdmin, String anh) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.FullName = fullName;
		this.Phone = phone;
		this.Address = address;
		this.Email = email;
		this.isSeller = isSeller;
		this.isAdmin = isAdmin;
		this.Anh = anh;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		this.FullName = fullName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public int getIsSeller() {
		return isSeller;
	}
	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		this.Anh = anh;
	}
	
	
}
