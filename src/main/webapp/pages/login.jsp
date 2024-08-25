<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String contextPath = request.getContextPath();%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cylinder Crew- Login</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/login.css" />
</head>
<body>
    <div class="container">
        <div class="box">

            <div class="box-desc2">
                <form onsubmit="required()" name="feedback" action="<%=contextPath%>/loginbuyer" method="post">
                    <h2>Login </h2>
                    <hr style="width:100%">
                    <p>
                        Welcome to our website! Cylinder Crew is here to connect buyers and distributers online. Get yourself cylinder crew who deliver LPG cylinder to your kitchen.
                    </p>
                    <label for="">Phone Number:</label>
                    <input type="text" name="Phone_Number" required><br>
                    <label for="">Password:</label>
                    <input type="password" name="password" required><br>
                    <div class="button">
                    <input type="submit" value="Login" class="LoginB"> 
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