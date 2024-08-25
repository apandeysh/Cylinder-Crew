package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        this.dbController = new dbController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the session and request objects
		HttpSession userSession = request.getSession();
		String Phno=userSession.getAttribute("PhoneNumber").toString();
		String user=userSession.getAttribute("user_type").toString();
		
		if(Phno==null ){
			request.getRequestDispatcher("/pages/LoginAdmin.jsp").forward(request, response);
		}

		else {
		if(user!="admin") {
			request.getRequestDispatcher("/pages/LoginAdmin.jsp").forward(request, response);
		}}
		
		// TODO Auto-generated method stub
			ArrayList<String> products = dbController.getProducts();
			userSession.setAttribute("product_list", products);
			int i=1;
			for (String product : products) {
				String a=i+"";
	            request.setAttribute(a, product);
	            i++;
	        }
			request.setAttribute("repitation", i);
			request.setAttribute("price", userSession.getAttribute("price"));
			request.getRequestDispatcher("/pages/Product.jsp").forward(request, response);
	       
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
