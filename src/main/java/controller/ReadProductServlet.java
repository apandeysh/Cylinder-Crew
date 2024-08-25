package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductsModel;

/**
 * Servlet implementation class ReadProductServlet
 */
@WebServlet("/ReadProductServlet")
public class ReadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final dbController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadProductServlet() {
        super();
        this.dbController = new dbController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Product_Name");
		ArrayList<ProductsModel> products = dbController.getProdcutsInfo();
		System.out.println(name);
		int price=99;
		for (ProductsModel product : products) {
			System.out.println(product.getPrice());
			if(product.getName().equals(name)) {
				System.out.println(product.getName()+"=="+name);
				price=product.getPrice();
				System.out.println(price);
				break;
			}
			else {
				price=0;
				System.out.println(price);
			}
		}
		HttpSession userSession = request.getSession();
		userSession.setAttribute("price", price);
		request.setAttribute("price", price);
		request.getRequestDispatcher("ProductServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
