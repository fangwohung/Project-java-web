<%-- 
    Document   : add
    Created on : Jul 2, 2018, 3:24:24 PM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm sinh viên</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            td {
                padding-bottom: 5px;
                padding-top: 5px;
                padding-right:  5px;
                padding-left:  5px;
            }
        </style>
    </head>

    <body>
        <%
            if (session.getAttribute("id") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <div>
            <form action="addSV" method="POST">
                <table>
                    <tr>
                        <td>Họ & tên</td>
                        <td>
                            <input type="text" class="form-control" name="fullname" >
                        </td>                   
                    </tr>
                    <tr>
                        <td>Ngày sinh</td>
                        <td>
                            <form>                                                             
                                <input type="date" name="bday"><br>
                            </form>
                        </td>                   
                    </tr>
                    <tr>
                        <td>Giới tính</td>
                        <td>
                            <select name="gioitinh">
                                <option value="1">Nam</option>
                                <option value="0">Nữ</option>
                            </select>   
                        </td>
                    </tr>
                    <tr>
                        <td>Khoa</td>
                        <td>
                            <input type="text" class="form-control" name="khoa" >
                        </td>                   
                    </tr>
                    <td>
                    <td colspan="2" style="text-align: center"><input class="btn btn-success" type="submit" value="Lưu">
                    </td>
                </table>
            </form>
        </div>
    </body>
</html>
