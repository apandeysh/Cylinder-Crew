package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginModel;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginAdminServlet" })
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
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
		// Extract email and password from the request parameters
        String phnumber = request.getParameter("PhoneNumber");
        String password = request.getParameter("password");

        // Create a LoginModel object to hold user credentials
        LoginModel loginModel = new LoginModel(phnumber, password);

        // Call DBController to validate login credentials
        int loginResult = dbController.getAdminLoginInfo(loginModel);
        // Handle login results with appropriate messages and redirects
        System.out.println(phnumber);
        if (loginResult == 1) {
            // Login successful
        	HttpSession userSession = request.getSession();
			userSession.setAttribute("PhoneNumber", phnumber);
			userSession.setAttribute("user_type", "admin");
			userSession.setMaxInactiveInterval(30*60);
			
			
			Cookie userCookie= new Cookie("Phone_Number", phnumber);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			System.out.println(userSession.getAttribute("PhoneNumber")+" "+ userSession.getAttribute("user_type"));
			
            request.setAttribute("sucess", "Sucessful Login");
			response.sendRedirect(request.getContextPath() + "/ProductServlet");
        } else if (loginResult == 0) {
            // email or password mismatch
            request.setAttribute("error", "Wrong Password! Enter your password again!");
			request.setAttribute("Phone_Number", phnumber);
            request.getRequestDispatcher("pages/LoginAdmin.jsp").forward(request, response);
        } else if (loginResult == -1) {
            // email not found
            request.setAttribute("error", "No account of this number! Create account to register!");
			request.setAttribute("Phone_Number", phnumber);
            request.getRequestDispatcher("pages/registerAdmin.jsp").forward(request, response);
        } else {
            // Internal server error
            request.setAttribute("error", "Server Error!");
			request.setAttribute("Phone_Number", phnumber);
            request.getRequestDispatcher("pages/LoginAdmin.jsp").forward(request, response);
        }
	}

}
