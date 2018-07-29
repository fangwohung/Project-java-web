<%-- 
    Document   : Logout
    Created on : Jul 10, 2018, 9:10:40 PM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>     
        <%
            session.invalidate();
            response.sendRedirect("");
        %>
    </body>
</html>
