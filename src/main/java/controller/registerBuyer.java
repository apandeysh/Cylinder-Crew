package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BuyerModel;
import utils.ValidationUtil;

@WebServlet("/registerBuyer")
public class registerBuyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerBuyer() {
		this.dbController = new dbController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("ffbs");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String name = request.getParameter("Name");
				String phoneNumber = request.getParameter("PhoneNumber");
				String email = request.getParameter("Email");
				String address = request.getParameter("Address");
				String password = request.getParameter("password");
				
				// Create a BuyerModel object to hold buyers' information
				BuyerModel Buyer = new BuyerModel(name,  phoneNumber,  email,  address,  password);
				
				// Implement data validation here (e.g., check for empty fields,// etc.)
				if(!ValidationUtil.isTextOnly(name) ||
						!ValidationUtil.isNumbersOnly(phoneNumber)) {
					request.setAttribute("error", "Please correct all the fields.");
					request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
				}
				
				
				// Call DBController to register the buyer
				int result = dbController.RegisterBuyers(Buyer);

				if (result == 1) {
					
					request.setAttribute("sucess", "Sucessfully Registered");
					response.sendRedirect(request.getContextPath() + "/pages/login.jsp"+ "?success=true");
				} else if (result == 0) {
					request.setAttribute("error", "Please correct all the fields.");
					request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "An unexpected server error occurred");
					request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
				
				}

	}

}
