package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminModel;

/**
 * Servlet implementation class RegisterAdminServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterAdminServlet" })
public class RegisterAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdminServlet() {
    	this.dbController = new dbController();
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
		String phnumber = request.getParameter("PhoneNumber");
		String password = request.getParameter("password");
		
		// Create a AdminModel object to hold buyers' information
		AdminModel admin = new AdminModel(phnumber, password);
		
		// Call DBController to register the buyer
		int result = dbController.RegisterAdmin(admin);

		if (result == 1) {
			
			request.setAttribute("sucess", "Sucessfully Registered");
			response.sendRedirect(request.getContextPath() + "/pages/LoginAdmin.jsp");
		} else if (result == 0) {
			request.setAttribute("error", "Please correct all the fields.");
			request.getRequestDispatcher("/pages/registerAdmin.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "An unexpected server error occurred");
			request.getRequestDispatcher("/pages/registerAdmin.jsp").forward(request, response);
		
		}
		
		
	}

}
