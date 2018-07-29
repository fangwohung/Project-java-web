<%-- 
    Document   : tracuu
    Created on : Jul 4, 2018, 8:18:42 PM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tra cứu sinh viên</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <style>

            .space
            {
                margin-left : 10px;
                margin-right: 10px;
            }
            .wrapper {
                text-align: left;
                padding-top: 10px;               
                padding-left: 10px;
            }
            td{
                padding-top: 10px;   
                padding-left: 10px;
            }

        </style>

    </head>

    <body>

        <div class="wrapper">
            <a href="Home">Home</a>
        </div>
        <form action="tracuu" method="POST">
            <table>
                <tr>
                    <td>
                        <input type="text" name="hoten" placeholder="Nhập họ và tên"> 
                    </td>           
                    <td>
                        <input type="date" class="space" name="ngaysinh">
                    </td>
                </tr>
                <tr>   
                    <td>
                        <input  type="text" name="khoa" placeholder="Nhập khoa">
                    </td> 
                    <td>
                        <select class="space" name="gioitinh">
                            <option value="1">Nam</option>
                            <option value="0">Nữ</option>
                        </select>  
                    </td>
                </tr>    
            </table>
            <div style="padding-left: 10px;">
                <button type="submit" name="search" value="Search" style="margin-top:5px;margin-bottom:5px;">
                    <img src="images/search_img.png" style="width: 20px; height: 20px" alt="phonestuff">
                </button>   
            </div>
            <center>   
                <div> 
                    <table border="1" class="table table-striped table-bordered">
                        <tr>
                            <th>ID</th>
                            <th>Họ & tên</th>
                            <th>Ngày sinh</th>
                            <th>Giới tính</th>
                            <th>Khoa</th>                  
                        </tr>
                        <c:forEach var="sv" items="${studentlist}">
                            <tr>
                                <td><c:out value="${sv.id}" /></td>
                                <td><c:out value="${sv.fullname}" /></td>
                                <td><c:out value="${sv.ngaysinh}" /></td>
                                <td><c:out value="${sv.gioitinh}" /></td>
                                <td><c:out value="${sv.khoa}" /></td>
                            </tr>
                        </c:forEach>
                    </table>  
                </div>
            </center>

            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <c:if test="${currentPage != 1}">
                        <a class="page-link" href="tracuu?page=${currentPage - 1}">Previous</a>
                    </c:if>
                </li>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <li class="page-item"><a class="page-link" >${i}</a></li>

                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="tracuu?page=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                <li class="page-item">
                    <c:if test="${currentPage lt noOfPages}">
                        <a  class="page-link" href="tracuu?page=${currentPage + 1}">Next</a>
                    </c:if>
                </li>
            </ul>

        </form>

    </body>
</html>
