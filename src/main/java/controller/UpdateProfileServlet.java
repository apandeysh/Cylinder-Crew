package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BuyerModel;
import utils.ValidationUtil;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        this.dbController = new dbController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession userSession = request.getSession();
		
		String name = request.getParameter("Name");
		String phoneNumber = userSession.getAttribute("PhoneNumber").toString();
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
		int result = dbController.UpdateBuyer(Buyer);

		if (result == 1) {
			response.sendRedirect(request.getContextPath() + "/ProfileServlet"+ "?success=true");
		} else if (result == 0) {
			request.setAttribute("error", "Please correct all the fields.");
			request.getRequestDispatcher("/pages/UpdateProfile.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "An unexpected server error occurred");
			request.getRequestDispatcher("/pages/UpdateProfile.jsp").forward(request, response);
		
		}
		
	}

}
