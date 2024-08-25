package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.StringUtils;
import model.AdminModel;
import model.BuyerModel;
import model.LoginModel;
import model.ProductsModel;

public class dbController {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Create a connection to the database using the provided credentials
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cylindercrew", "root",
				"");
	}
	
	public int GetPriceFromDatabase(String productname) {
		System.out.println("checked1");
		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement("SELECT Product_Price FROM product WHERE Product_Name = ?;");

			// Set the student information in the prepared statement
			stmt.setString(1, productname);
			System.out.println("checked2");
			// Execute the update statement and store the number of affected rows
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int price = result.getInt("Product_Price");
				System.out.println(price);
				System.out.println("checked");
				return price;
			}
			

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
		return 0;
	}

	public int RegisterBuyers(BuyerModel buyers) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_BUYER);

			// Set the student information in the prepared statement
			stmt.setString(1, buyers.getName());
			stmt.setString(2, buyers.getPhoneNumber());
			stmt.setString(3, buyers.getEmail());
			stmt.setString(4, buyers.getAddress());
			stmt.setString(5, buyers.getPassword());

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	public int UpdateBuyer(BuyerModel buyers) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement("UPDATE buyer\r\n"
					+ "SET Buyer_Name = ?, Buyer_Email = ?, Buyer_Address = ?, Buyer_Password = ?\r\n"
					+ "WHERE Buyer_Phone_Number=?;");

			// Set the student information in the prepared statement
			stmt.setString(1, buyers.getName());
			stmt.setString(2, buyers.getEmail());
			stmt.setString(3, buyers.getAddress());
			stmt.setString(4, buyers.getPassword());
			stmt.setString(5, buyers.getPhoneNumber());

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	
	public int RegisterAdmin(AdminModel admin) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_ADMIN);

			// Set the student information in the prepared statement
			stmt.setString(1, admin.getPhone_Number());
			stmt.setString(2, admin.getPassword());

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int CreateProduct(ProductsModel product) {

		try {
			String priceS=product.getPrice()+" ";
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO product (Product_Name, Product_Price)\r\n"
					+ "VALUES (?,?)");

			// Set the student information in the prepared statement
			stmt.setString(1, product.getName());
			stmt.setString(2, priceS);

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int UpdateProduct(ProductsModel product) {

		try {
			String priceS=product.getPrice()+" ";
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement("UPDATE product SET Product_Price = ? WHERE Product_Name=?;");

			// Set the student information in the prepared statement
			stmt.setString(2, product.getName());
			stmt.setString(1, priceS);
			
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int DeleteProduct(String product) throws ClassNotFoundException, SQLException {
		String productname=product;
		PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM product WHERE Product_Name = ?;");
		
		stmt.setString(1, productname);
		int result = stmt.executeUpdate();
		

		// Check if the update was successful (i.e., at least one row affected)
		if (result > 0) {
			return 1; // Registration successful
		} else {
			return 0; // Registration failed (no rows affected)
		}
		
		
	}
	
	public int getAdminLoginInfo(LoginModel loginModel) {
		// Try-catch block to handle potential SQL or ClassNotFound exceptions
		try {
			// Prepare a statement using the predefined query for login check
			PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_ADMIN_CHECK);

			// Set the email in the first parameter of the prepared statement
			st.setString(1,loginModel.getPhone_number());

			System.out.print(loginModel.getPhone_number());
			// Execute the query and store the result set
			ResultSet result = st.executeQuery();
			// Check if there's a record returned from the query
			if (result.next()) {
				// Get the email from the database
				String userDb = result.getString("Admin_Email");
				System.out.println(userDb);
				

				// Get the password from the database
				String encryptedPwd = result.getString("Admin_Password");
				System.out.println(encryptedPwd);
				System.out.println(loginModel.getPassword());
				
				
				// Check if the email and password match the credentials from the database
				if (userDb.equals(loginModel.getPhone_number()) && encryptedPwd.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// email or password mismatch, return 0
					return 0;
				}
			} else {
				// email not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException | ClassNotFoundException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}
	
	public int getBuyersLoginInfo(LoginModel loginModel) {
		// Try-catch block to handle potential SQL or ClassNotFound exceptions
		try {
			// Prepare a statement using the predefined query for login check
			PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_USER_CHECK);

			// Set the email in the first parameter of the prepared statement
			st.setString(1,loginModel.getPhone_number());

			// Execute the query and store the result set
			ResultSet result = st.executeQuery();

			// Check if there's a record returned from the query
			if (result.next()) {
				// Get the email from the database
				String userDb = result.getString("Buyer_Phone_Number");
				System.out.println(userDb);

				// Get the password from the database
				String encryptedPwd = result.getString("Buyer_Password");
				
				// Check if the email and password match the credentials from the database
				if (userDb.equals(loginModel.getPhone_number()) && encryptedPwd.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// email or password mismatch, return 0
					return 0;
				}
			} else {
				// email not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException | ClassNotFoundException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}

	public ArrayList<ProductsModel> getProdcutsInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement("SELECT product_name, product_price FROM product;");
			ResultSet result = stmt.executeQuery();

			ArrayList<ProductsModel> products = new ArrayList<ProductsModel>();

			while (result.next()) {
				ProductsModel product = new ProductsModel();		
				product.setName(result.getString("product_name"));
				product.setPrice(Integer.parseInt(result.getString("product_price")));
				products.add(product);
			}
			
			return products;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<String> getProducts() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement("SELECT product_name FROM product;");
			ResultSet result = stmt.executeQuery();

			ArrayList<String> products = new ArrayList<String>();

			while (result.next()) {
				String product = result.getString("product_name");
				System.out.println(result.getString("product_name"));
				products.add(product);
			}
			
			return products;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public BuyerModel getBuyerInfo(String PhoneNumber) {
		System.out.println(PhoneNumber);
		try {
			System.out.println("check1");
			PreparedStatement stmt = getConnection().prepareStatement("SELECT Buyer_Name, Buyer_Phone_Number, Buyer_Email, Buyer_Address, Buyer_Password from buyer where Buyer_Phone_Number=?;");
			stmt.setString(1, PhoneNumber);
			ResultSet result = stmt.executeQuery();
			BuyerModel buyer = new BuyerModel();
			while (result.next()) {
			buyer.setName(result.getString("Buyer_Name"));
			buyer.setPhoneNumber(result.getString("Buyer_Phone_Number"));
			buyer.setEmail(result.getString("Buyer_Email"));
			buyer.setAddress(result.getString("Buyer_Address"));
			buyer.setPassword(result.getString("Buyer_Password"));
			System.out.println(buyer.getPassword());
			}
			return buyer;
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("check3");
			return null;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("check2");
			return null;
		}
	}
	
	
}
