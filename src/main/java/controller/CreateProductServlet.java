package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductsModel;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet("/CreateProductServlet")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductServlet() {
        super();
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
		String name = request.getParameter("Product_Name");
		int price = Integer.parseInt(request.getParameter("Price"));
		
		// Create a AdminModel object to hold buyers' information
		ProductsModel product = new ProductsModel(name, price);
		
		// Call DBController to register the buyer
		int result = dbController.CreateProduct(product);

		if (result == 1) {
			
			request.setAttribute("Product", "Sucessfully Registered");
			response.sendRedirect(request.getContextPath() + "/ProductServlet");
		} else if (result == 0) {
			request.setAttribute("Product", "Please correct all the fields.");
			request.getRequestDispatcher("/ProductServlet").forward(request, response);
		} else {
			request.setAttribute("Product", "An unexpected server error occurred");
			request.getRequestDispatcher("/ProductServlet").forward(request, response);
		
		}
	}

}
