<%-- 
    Document   : login
    Created on : Jul 1, 2018, 10:42:27 AM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <%
            if (session != null) {
                if (session.getAttribute("id") != null) {
                    response.sendRedirect("Home");
                }
            }
        %>
        <h1 style="color:red;">
            <%
                String error = (String) request.getAttribute("error");
                if (error != null) {
                    out.println(error);
                }
            %>
        </h1>
    <center>Login
        <div>
            <form action="login" method="POST">
                <table>
                    <tr>
                        <td>User name</td>
                        <td>
                            <input type="text" class="form-control" name="username" placeholder="User name" required 
                                    oninvalid="this.setCustomValidity('Please Enter User Name Here')" oninput="this.setCustomValidity('')" >
                        </td>                   
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" class="form-control" name="password" placeholder="Password" required
                                   oninvalid="this.setCustomValidity('Please Enter Password Here')" oninput="this.setCustomValidity('')">
                        </td>                   
                    </tr>
                    <td>
                    <td colspan="2" style="text-align: center"><input class="btn btn-success" type="submit" value="Đăng nhập">
                    </td>
                </table>
            </form>
        </div>
    </center>
</body>
</html>
