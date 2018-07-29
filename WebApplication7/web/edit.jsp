<%-- 
    Document   : edit
    Created on : Jul 1, 2018, 8:43:54 PM
    Author     : quochung
--%>

<%@page import="Model.Student"%>
<%@page import="DAO.StudentDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa sinh viên</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%
            if (session.getAttribute("id") == null) {
                response.sendRedirect("login.jsp");
            }
            String id = request.getParameter("idsv");
            StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
            Student sinhvien = studentDAOImpl.getStudent(id);
            String nam = "", nu = "";
            if (sinhvien.getGioitinh().equals("Nam")) {
                nam = "selected";
            } else {
                nu = "selected";
            }

        %>
        <div>
            <form action="EditStudent" method="POST">
                <table>
                    <tr>
                        <td>ID</td>
                        <td>                            
                            <input type="hidden" name="masv" value="<%= sinhvien.getId()%>">
                        </td>                   
                    </tr>
                    <tr>
                        <td>Họ & tên</td>
                        <td>
                            <input type="text" class="form-control" name="fullname" value="<%= sinhvien.getFullname()%>">
                        </td>                   
                    </tr>
                    <tr>
                        <td>Ngày sinh</td>
                        <td>
                            <form>                                                             
                                <input type="date" name="bday" value="<%= sinhvien.getNgaysinh()%>"><br>
                            </form>
                        </td>                   
                    </tr>
                    <tr>
                        <td>Giới tính</td>
                        <td>
                            <select name="gioitinh" >
                                <option value="1" <%= nam%>>Nam</option>
                                <option value="0" <%= nu%>>Nữ </option>
                            </select>   
                        </td>
                    </tr>
                    <tr>
                        <td>Khoa</td>
                        <td>
                            <input type="text" class="form-control" name="khoa" value="<%= sinhvien.getKhoa()%>" >
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
