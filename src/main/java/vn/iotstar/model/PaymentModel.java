package vn.iotstar.model;

public class PaymentModel {
	private int id;
	private String payment;
	
	public PaymentModel() {
		super();
	}
	public PaymentModel(int id, String payment) {
		super();
		this.id = id;
		this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
}
