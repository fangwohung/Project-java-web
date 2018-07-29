<%-- 
    Document   : delete
    Created on : Jul 3, 2018, 10:28:11 PM
    Author     : quochung
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="Model.Student"%>
<%@page import="DAO.StudentDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            if (session.getAttribute("id") == null) {
                response.sendRedirect("login.jsp");
            } else {
                String id = request.getParameter("IDSV");
                StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
                Student sinhvien = studentDAOImpl.getStudent(id);
                
                if (studentDAOImpl.xoa(sinhvien)) {
                    response.sendRedirect("Home");
                } 
                else
                {
                    response.getWriter().print("Xóa dữ liệu thất bại!");
                }
            }
        %>
    </body>
</html>
