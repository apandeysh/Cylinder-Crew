package model;

public class LoginModel {
	private String phone_number;
	private String password;
	
	
	/**
	 * @param phone_number
	 * @param password
	 */
	public LoginModel(String phone_number, String password) {
		super();
		this.phone_number = phone_number;
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}