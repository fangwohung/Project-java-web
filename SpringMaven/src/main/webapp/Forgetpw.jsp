<%-- 
    Document   : newjsp
    Created on : Jul 11, 2018, 6:51:54 PM
    Author     : quochung
--%>

<%@page import="Article.Model.TaiKhoanModel"%>
<%@page import="Article.DAO.TaiKhoanDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          
                String username = request.getParameter("Username");
                String pw = "";
                try {
                    out.println("Your user name: " + username+"</br>");
                    if (username == null || username.trim().equals("")) {

                        out.println("Please enter User name");
                    } else {
                        TaiKhoanModel tk = new TaiKhoanModel();
                        tk.setUserName(username);
                        TaiKhoanDAOImpl taikhoan = new TaiKhoanDAOImpl();
                        pw = taikhoan.getPassword(tk);
                        out.println("Your password: " + pw);
                    }
                } catch (Exception e) {
                }           
        %>
    </body>
</html>
