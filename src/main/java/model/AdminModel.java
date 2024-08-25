package model;

public class AdminModel {
	private String Phone_Number;
	private String password;
	
	
	/**
	 * @param phone_Number
	 * @param password
	 */
	public AdminModel(String phone_Number, String password) {
		super();
		Phone_Number = phone_Number;
		this.password = password;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
