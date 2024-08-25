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
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/footer.css" />
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/header.css" />
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/Profile.css" />
</head>
<body>
	<%
		String name=userSession.getAttribute("name").toString();
		String phone=userSession.getAttribute("phone").toString();
		String email=userSession.getAttribute("email").toString();
		String address=userSession.getAttribute("address").toString();
		String password=userSession.getAttribute("password").toString();

	%>
	<%@include file="../pages/header.jsp"%> 
	 <div class="container">
        <div class="row">
            
            <div class="box-desc"><!-- adding the details of the team members-->
                <h2>Cylinder Crew </h2>
                <div class=imagecontainer> <img src="../Pictures/Profile.jpg" class="product-pic" ></div>
                <hr style="width:100%">
                <h3>Name</h3>   
                <%
                out.println(name);
                %>            
                <h3>Phone Number</h3>
                <%
                out.println(phone);
                %> 

                <h3>Email</h3>
                <%
                out.println(email);
                %> 

                <h3>Address</h3>
                <%
                out.println(address);
                %> 

                <h3>Password</h3>
                <%
                out.println(password);
                %> 
                <div style="padding-top: 50px; padding-left: 150px;">
                <a href="${pageContext.request.contextPath}/pages/UpdateProfile.jsp" class="button">Update Profile</a></div>
            </div>
        </div>
	</div>
	
	
	<%@include file="../pages/footer.jsp"%> 
</body>
</html>