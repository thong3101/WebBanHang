package vn.iotstar.model;

import java.util.Date;

public class CartModel {
	private String id;
	private AcountModel buyer;
	private float total;
	private Date buyDate;
	
	
	
	
	public CartModel() {
		super();
	}
	public CartModel(String id, AcountModel buyer, float total, Date buyDate) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.total = total;
		this.buyDate = buyDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AcountModel getBuyer() {
		return buyer;
	}
	public void setBuyer(AcountModel buyer) {
		this.buyer = buyer;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	
	
}
