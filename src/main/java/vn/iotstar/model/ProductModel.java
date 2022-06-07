package vn.iotstar.model;

public class ProductModel {
	private int pid;
	private String pname;
	private String pdescription;
	private int price;
	private String imageLink;
	private int cid;
	private int sellerid;
	private int discount;
	private int hangcon;
	private int daban;
	private int status;
	
	
	
	
	public ProductModel() {
		super();
	}
	public ProductModel(int pid, String pname, String pdescription, int price, String imageLink, int cid, int sellerid,
			int discount, int hangcon, int daban,int status) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.price = price;
		this.imageLink = imageLink;
		this.cid = cid;
		this.sellerid = sellerid;
		this.discount = discount;
		this.hangcon = hangcon;
		this.daban = daban;
		this.status=status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getHangcon() {
		return hangcon;
	}
	public void setHangcon(int hangcon) {
		this.hangcon = hangcon;
	}
	public int getDaban() {
		return daban;
	}
	public void setDaban(int daban) {
		this.daban = daban;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
