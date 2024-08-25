package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        this.dbController = new dbController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productname=request.getParameter("Product_Name");
		int result;
		
		try {
			result = dbController.DeleteProduct(productname);
		
			if (result == 1) {
				
				request.setAttribute("Message", "Sucessfully Updates");
				response.sendRedirect(request.getContextPath() + "/ProductServlet");
			} else if (result == 0) {
				request.setAttribute("Message", "Please correct all the fields.");
				request.getRequestDispatcher("/ProductServlet").forward(request, response);
			} else {
				request.setAttribute("Message", "An unexpected server error occurred");
				request.getRequestDispatcher("/ProductServlet").forward(request, response);
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
