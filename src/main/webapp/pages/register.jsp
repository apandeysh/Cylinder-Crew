<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
String contextPath = request.getContextPath();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/register.css" />
</head>
<body>
	<div class="container">
	        <div class="box">
	
	            <div class="box-desc2">
	                <form action="<%=contextPath%>/registerBuyer" onsubmit="required()" method="post" name="register" >
	                    <h2>Register User </h2>
	                    <hr style="width:100%">
	                    <label for="">Full Name:</label>
	                    <input type="text" name="Name" required><br>
	                    <label for="">Phone Number:</label>
	                    <input type="text" name="PhoneNumber"required><br>
	                    <label for="">Email:</label>
	                    <input type="email" name="Email"required><br>
	                    <label for="">Address:</label>
	                    <input type="text" name="Address"required><br>
	                    <label for="">Password:</label>
	                    <input type="password" name="password"required><br>
	                    <div class="button">
	                    <input type="submit" value="Register" class="RegisterB">
	                    </div>
	                </form>    
					<%
		String errorMessage = (String) request.getAttribute("error");

		if (errorMessage != null) {
			// print
		%>
		<h4 class="error-msg" style= "color: red; padding-left: 100px">
			<%
			out.println(errorMessage);
			%>
		</h4>
		<%
		}

		%>
		
	
	            </div>
	        </div>
	    </div>

</body>
</html>