<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<div id="header">
    <header class="header">
    	<div class="part">
	        <div class="cloumn">
	        	<img src="${pageContext.request.contextPath }/Pictures/Logo.png" alt="LOGO" style="height: 65px" >
	        </div>
	           <div class="cloumn">
	           		<nav>
		                <ul  class="Navlist">
		                    <ls>
		                        <a href="${pageContext.request.contextPath }/index.jsp" class="linkitem">Home</a>
		                    </ls>
		                    <ls>
		                        <a href="${pageContext.request.contextPath }/ProductServlet" class="linkitem">Product</a>
		                    </ls>
		                    <ls>
		                        <a href="${pageContext.request.contextPath }/ProfileServlet" class="linkitem">Profile</a>
		                    </ls>
		                    <ls>
		                        <a href="#" class="linkitem">Order</a>
		                    </ls>
		                    <ls>
		                        <a href="#" class="linkitem">AboutUs</a>
		                    </ls>
		                </ul>
	            	</nav>
	            </div>
	            <div class="cloumn">
		            <div class="buttons">
		            	
                		<form action="<%
	                    // Conditionally set the action URL based on user session
	                    if (Phno != null) {
	                        out.print(contextPath + "/logout");
	                    } else {
	                        out.print(contextPath + "/pages/login.jsp");
	                    }
	                	%>" method="post">
	                    <input type="submit" class="button1" value="<%
	                        // Conditionally set the button label based on user session
	                        if (Phno != null) {
	                            out.print("Log out");
	                        } else {
	                            out.print("Log in");
	                        }
	                    %>"/>
	                	</form>
                		
		                <a href="${pageContext.request.contextPath}/pages/register.jsp" class="button2">Register</a>
		            </div>
	            </div>
            </div>
    </header>
</div>