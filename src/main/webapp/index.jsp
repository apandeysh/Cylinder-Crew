<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
HttpSession userSession = request.getSession();
String Phno = (String) userSession.getAttribute("Phone_Number");
%>    
    

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Cylinder Crew</title>
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/footer.css" />
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/header.css" />
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/index.css" />
	</head>
	<body>
	<%@include file="pages/header.jsp"%> 
	<%
		//response.setHeader("Cashe-Control", "no-cashe,no-store must revalidate");
	%>
	<div class="SliderContainer">
	        <div id="slideEffects">
	            <img src="Pictures/billboard1.png">
	        </div>
	    </div>
	    <script>
	        var imagePath = ['Pictures/billboard1.png','Pictures/billboard2.png','Pictures/billboard3.png'];
	        var container =document.getElementById("slideEffects");
	        var i=0;
	        setInterval(slide,3000)
	        function slide(){
	        if(i<imagePath.length)
	        {
	            i=i+1;
	        }
	        else{
	            i=1;
	        }
	        container.innerHTML = "<img src="+imagePath[i-1]+">";
	    }
	    </script>
	   
	    
	<%@include file="pages/footer.jsp"%> 
	</body>
</html>