package model;

public class BuyerModel {
	private String Name;
	private String phoneNumber;
	private String email;
	private String address;
	private String password;
	
	
	public BuyerModel(String name, String phoneNumber, String email, String address, String password) {
		super();
		Name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.password = password;
	}


	public BuyerModel() {
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
