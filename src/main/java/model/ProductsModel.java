package model;

public class ProductsModel {
	private String Name;
	private int price;
	/**
	 * @param name
	 * @param price
	 */
	public ProductsModel(String name, int price) {
		super();
		Name = name;
		this.price = price;
	}
	public ProductsModel() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
}
