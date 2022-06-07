package vn.iotstar.model;

public class BillModel {
	private int id;
	private CartModel cart;
	private String orderName;
	private String orderAddress;
	private String orderPhone;
	private String orderEmail;
	private int shipprice;
	private int subtotal;
	private String payment;
	
	
	
	public BillModel() {
		super();
	}
	public BillModel(int id, CartModel cart, String orderName, String orderAddress, String orderPhone,
			String orderEmail, int shipprice, int subtotal, String payment) {
		super();
		this.id = id;
		this.cart = cart;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.shipprice = shipprice;
		this.subtotal = subtotal;
		this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CartModel getCart() {
		return cart;
	}
	public void setCart(CartModel cart) {
		this.cart = cart;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrderEmail() {
		return orderEmail;
	}
	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}
	public int getShipprice() {
		return shipprice;
	}
	public void setShipprice(int shipprice) {
		this.shipprice = shipprice;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
}
