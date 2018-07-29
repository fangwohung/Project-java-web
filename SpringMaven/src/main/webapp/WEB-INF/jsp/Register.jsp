<%-- 
    Document   : Register
    Created on : Jul 11, 2018, 9:25:47 AM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            input{
                width: 30%;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Register Here</h1>
            <form:form method="POST" action="register" modelAttribute="taikhoan">

                <form:input path="userName" class="form-control"  placeholder="Enter Username"/>

                <form:password path="password" class="form-control" placeholder="Enter Password"/>

                <center><input type="submit" class="btn btn-success" value="Register"/></center>
                <p style="color: red;">${msg}</p>
            </form:form>
        </div>
    </body>
</html>
