package vn.iotstar.model;

public class CityModel {
	private String cityname;
	private int priceship;
	
	
	
	public CityModel() {
		super();
	}
	public CityModel(String cityname, int priceship) {
		super();
		this.cityname = cityname;
		this.priceship = priceship;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getPriceship() {
		return priceship;
	}
	public void setPriceship(int priceship) {
		this.priceship = priceship;
	}
	
}
