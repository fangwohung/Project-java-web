<%-- 
    Document   : welcome
    Created on : Jul 1, 2018, 11:52:39 AM
    Author     : quochung
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .wrapper {
                text-align: right;
                padding-bottom: 10px;
                padding-right: 10px;
            }
            .paddingbutton {
                text-align: left;
                padding-top:  10px;
                padding-left: 10px;
            }
             .leftpadding {
                text-align: left;
                padding-bottom: 10px;
                padding-left:  10px;
            }
        </style>
    </head>

    <body>
        <%
            if (session.getAttribute("id") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <div class="paddingbutton">  
            <input type="button" onclick="location.href = 'logout.jsp';" 
                   class="btn btn-danger" name="logout" value="Đăng xuất">
        </div>
    <center>   
        <b> <font size="9">Danh sách sinh viên</font></b>
        <div> 
            <form action="Home" method="POST">
                <div class="leftpadding">
                    <a href="tracuu">Tra cứu sv</a>
                </div>
                <div class="wrapper">                   
                    <input type="button" onclick="location.href = 'add.jsp';" 
                           class="btn btn-success" name="add" value="Add">                      
                </div>

                <table border="1" class="table table-striped table-bordered">
                    <tr>
                        <th width="5%">ID</th>
                        <th width="30%">Họ & tên</th>
                        <th width="8%">Ngày sinh</th>
                        <th width="8%">Giới tính</th>
                        <th width="30%">Khoa</th>
                        <th >Chức năng</th>
                    </tr>
                    <c:forEach var="sv" items="${dssv}">
                        <tr>
                            <td><c:out value="${sv.id}" /></td>
                            <td><c:out value="${sv.fullname}" /></td>
                            <td><c:out value="${sv.ngaysinh}" /></td>
                            <td><c:out value="${sv.gioitinh}" /></td>
                            <td><c:out value="${sv.khoa}" /></td>
                            <td>                                                                       
                                <input type="button" onclick="location.href = 'edit.jsp?idsv=${sv.id}';" 
                                       class="btn btn-info" value="Edit">
                                <input type="button" onclick="location.href = 'delete.jsp?IDSV=${sv.id}';" 
                                       class="btn btn-danger" value="Delete">
                            </td>
                        </tr>
                    </c:forEach>
                </table>  
            </form>
        </div>
    </center>

</body>
</html>
