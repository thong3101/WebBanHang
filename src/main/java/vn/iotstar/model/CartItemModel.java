package vn.iotstar.model;

public class CartItemModel {
	private int id;
	private int quantity;
	private float unitPrice;
	private ProductModel product;
	private CartModel cartid;
	private int sellerid;
	
	
	public CartItemModel() {
		super();
	}
	public CartItemModel(int id, int quantity, float unitPrice, ProductModel product, CartModel cartid, int sellerid) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
		this.cartid = cartid;
		this.sellerid = sellerid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public CartModel getCartid() {
		return cartid;
	}
	public void setCartid(CartModel cartid) {
		this.cartid = cartid;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	
}
