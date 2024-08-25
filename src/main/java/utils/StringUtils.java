package utils;

public class StringUtils {
	// Start: Queries
		public static final String QUERY_REGISTER_BUYER= "INSERT INTO `buyer` (`Buyer_ID`, `Buyer_Name`, `Buyer_Phone_Number`, `Buyer_Email`, `Buyer_Address`, `Buyer_Password`) "
						+ "VALUES (NULL, ?, ?, ?, ?, ?);";
		
		public static final String QUERY_REGISTER_ADMIN= "INSERT INTO `admin` (`Admin_Email`, `Admin_Password`) VALUES (?, ?);";

		public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM buyer WHERE Buyer_Phone_Number = ?;";
		public static final String QUERY_LOGIN_ADMIN_CHECK = "SELECT * FROM admin WHERE Admin_Email = ?;";

		public static final String QUERY_GET_ALL_PRODUCTS = "SELECT * FROM product;";
		public static final String QUERY_GET_USER_ID = "SELECT Buyer_ID FROM 'buyer' WHERE Buyer_Email = ?";
		public static final String QUERY_DELETE_USER = "DELETE FROM 'buyer' WHERE Buyer_Email = ?";
		
		
		
		// Start: Servlet Route
		public static final String SERVLET_URL_LOGIN = "/login";
		public static final String SERVLET_URL_REGISTER = "/registerstudent";
		public static final String SERVLET_URL_LOGOUT = "/logout";
		public static final String SERVLET_URL_HOME = "/home";
		public static final String SERVLET_URL_MODIFY_USER = "/modifyUser";
		// End: Servlet Route

		// Start: Normal Text
		public static final String USER = "user";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		public static final String STUDENT_MODEL = "studentModel";
		public static final String STUDENT_LISTS = "studentLists";
		public static final String SLASH= "/";
		public static final String DELETE_ID= "deleteId";
		public static final String UPDATE_ID= "updateId";
		
		// Start: JSP Route
		public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
		public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
		public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
		public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
		public static final String PAGE_URL_HEADER = "pages/header.jsp";
		public static final String URL_LOGIN = "/login.jsp";
		public static final String URL_INDEX = "/index.jsp";
		// End: JSP Route
}
