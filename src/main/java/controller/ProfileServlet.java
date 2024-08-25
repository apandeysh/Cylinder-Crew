package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BuyerModel;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        this.dbController = new dbController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession();
		String Phno=userSession.getAttribute("PhoneNumber").toString();
		String user=userSession.getAttribute("user_type").toString();
		String contextPath = request.getContextPath();
		System.out.println(Phno+user+contextPath);
		if(Phno==null ){
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		}

		else {
		if(user!="buyer") {
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		}}
		BuyerModel buyer = dbController.getBuyerInfo(Phno);
		userSession.setAttribute("name", buyer.getName());
		userSession.setAttribute("phone", buyer.getPhoneNumber());
		userSession.setAttribute("email", buyer.getEmail());
		userSession.setAttribute("address", buyer.getAddress());
		userSession.setAttribute("password", buyer.getPassword());
		
		System.out.println(Phno+user+contextPath);
		
		request.getRequestDispatcher("/pages/Profile.jsp").forward(request, response);
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
