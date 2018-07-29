<%-- 
    Document   : Login
    Created on : Jul 9, 2018, 5:47:17 PM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="/WEB-INF/css/style.css"%></style>

    </head>
    <body>       
        <%
            if (session != null) {
                if (session.getAttribute("id") != null) {
                    response.sendRedirect("MainMenu");
                }
            }
            
        %>
        <div class="login-box">
            <h1>Login Here</h1>
            <form:form method="POST" action="${pageContext.request.contextPath}/login" modelAttribute="taikhoan">
                <p>Username</p>
                <form:input path="userName"  placeholder="Enter Username" value="${id}"/>
                <p>Password</p>
                <form:password path="password"  placeholder="Enter Password" value="${pass}"/>                
                <input type="submit" value="Login">                                               
                <input type="checkbox"  name="remember-me" >Remember me</br> 
                <a href="reg">Register</a></br>
                <a href="forgetpw">Forget Password</a>
                <p style="color: red;">${msg}</p>
            </form:form>
        </div>

    </body>
</html>
