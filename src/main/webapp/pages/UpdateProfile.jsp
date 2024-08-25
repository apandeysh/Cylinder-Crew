<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/register.css" />

</head>
<body>
<%
//Get the session and request objects
HttpSession userSession = request.getSession();
String currentUser = (String) userSession.getAttribute("PhoneNumber");
String Phno=userSession.getAttribute("PhoneNumber").toString();
String user=userSession.getAttribute("user_type").toString();
String name=userSession.getAttribute("name").toString();
String email=userSession.getAttribute("email").toString();
String address=userSession.getAttribute("address").toString();
String password=userSession.getAttribute("password").toString();
%>   
	<div class="container" style="height:500">
	        <div class="box" style="height:500px">
	
	            <div class="box-desc2">
	                <form action="<%=contextPath%>/UpdateProfileServlet" onsubmit="required()" method="post" name="update" >
	                    <h2>Update Profile </h2>
	                    <hr style="width:100%">
	                    <label for="">Full Name:</label>
	                    <input type="text" name="Name" value="<%out.println(name); %>" required><br>
	                    <label for="">Email:</label>
	                    <input type="text" name="Email" value="<%out.println(email); %>" required><br>
	                    <label for="">Address:</label>
	                    <input type="text" name="Address" value="<%out.println(address); %>" required><br>
	                    <label for="">Password:</label>
	                    <input type="text" name="password" value="<%out.println(password); %>" required><br>
	                    <div class="button">
	                    <input type="submit" value="Update Profile" class="RegisterB">
	                    </div>
	                </form>    	
	            </div>
	        </div>
	    </div>
</body>
</html>