<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
//Get the session and request objects
HttpSession userSession = request.getSession();
String currentUser = (String) userSession.getAttribute("PhoneNumber");
String contextPath = request.getContextPath();
String Phno=userSession.getAttribute("PhoneNumber").toString();
String user=userSession.getAttribute("user_type").toString();
%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page- CylinderCrew</title>
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/footer.css" />
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/header.css" />
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/Product.css" />
</head>
<body>
<%
if(Phno==null ){
	request.getRequestDispatcher("../pages/LoginAdmin.jsp").forward(request, response);
}

else {
if(user!="admin") {
	request.getRequestDispatcher("../pages/LoginAdmin.jsp").forward(request, response);
}}%>
	
	
<%@include file="../pages/header.jsp"%> 
	<h1 style="text-align: center;">Welcome back Admin!<span style="color:#928D8D ;"> Create, Read, Update and Delete here!!</span></h1>
    <div class="container">
        <div class="box" >
            <div class="box-desc2">
            <h1>Create Product</h1>
            <hr style="width:100%">
            <form onsubmit="required()" name="create" action="<%=contextPath%>/CreateProductServlet"method="post">
                    <div class="desgin">
                    	<label style="color: black;"for="">Product Name:</label>
	                    <input type="text" name="Product_Name" required><br><br>
	                    <label style="color: black;" for="">Price:</label>
	                    <input type="number" name="Price" required><br><br>
                    </div>
                    <div class="button">
                    <input type="submit" value="Create" class="CreateB"> 
                    </div>
                </form> 
               </div>
            
        </div>

        <div class="box">
            <div class="box-desc2">
            	<h1>Read Product</h1>
            	<hr style="width:100%">
            	<form onsubmit="required()" name="read" action="<%=contextPath%>/ReadProductServlet">
                    <div class="desgin">
                    	<label style="color: black;"for="">Product Name:</label>
	                    <input type="text" name="Product_Name" required><br><br>
						<% Object productprice = request.getAttribute("price");
						%>
						 
	                    <label style="color: black;" for="">Price:</label>
	                    <input type="text" name="Price" value="<%
	                    out.println(productprice+"");
	                    %>"><br><br>
                    </div>
                    <div class="button">
                    <input type="submit" value="Read" class="ReadB"> 
                    </div>
                </form> 
            </div>
        </div>

        <div class="box" >
            <div class="box-desc2">
                <h1>Update Product</h1>
                <hr style="width:100%">
            	<form onsubmit="required()" name="Update" action="<%=contextPath%>/UpdateProductServlet">
                    <div class="desgin">
                    	<label style="color: black;"for="">Product Name:</label>
	                    <input type="text" name="Product_Name" required><br><br>
	                    <label style="color: black;" for="">Price:</label>
	                    <input type="number" name="Price" required><br><br>
                    </div>
                    <div class="button">
                    <input type="submit" value="Update" class="UpdateB"> 
                    </div>
                </form> 
            </div>
        </div>
        
         <div class="box">
            <div class="box-desc2">
                <h1>Delete Product</h1>
                <hr style="width:100%">
            	<form onsubmit="required()" name="create" action="<%=contextPath%>/DeleteProductServlet">
                    <div class="desgin"><br><br>
                    	<label style="color: black;"for="">Product Name:</label>
	                    <input type="text" name="Product_Name" required><br><br><br><br>
                    </div>
                    <div class="button">
                    <input type="submit" value="Delete" class="DeleteB"> 
                    </div>
                </form> 
            </div>
        </div>

    </div>
    <h1></h1>	
	
<%@include file="../pages/footer.jsp"%> 
</body>
</html>