<%-- 
    Document   : Home
    Created on : Jul 9, 2018, 5:47:05 PM
    Author     : quochung
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách SV</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">       
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>              
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">      
        <script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css">          


    </head>
    <body>
        <%
            if (session.getAttribute("id") == null) {
                response.sendRedirect("");
            }
        %>
        <input type="button" onclick="location.href = 'Logout';" 
               class="btn btn-danger" name="logout" value="Đăng xuất" 
               style="margin-left: 10px;margin-bottom: 10px;">
        <div>          

            <table>
                <tr>                        
                    <td>
                        <input type="hidden" id="hidden_ID"  name="hidden_ID" >
                    </td>                   
                </tr>
                <tr>
                    <td>Họ & tên</td>
                    <td>
                        <input type="text" id="fullname" class="form-control" name="fullname" >
                    </td>                   
                </tr>
                <tr>
                    <td>Ngày sinh</td>
                    <td>
                        <input type="text" id="datepicker" class="form-control" name="ngaysinh"></p>
                    </td>                   
                </tr>
                <tr>
                    <td>Giới tính</td>
                    <td>
                        <select name="gioitinh" id="gioitinh">
                            <option value="Nam">Nam</option>
                            <option value="Nữ">Nữ</option>
                        </select>   
                    </td>
                </tr>
                <tr>
                    <td>Khoa</td>
                    <td>
                        <input type="text" id="khoa" class="form-control" name="khoa" >
                    </td>   
                    <td colspan="5" style="text-align: center">
                        <input id="save" name="save" class="btn btn-success" type="submit"  value="Save">
                        <input type="submit" id="edit" name="edit" 
                               class="btn btn-info" value="Edit">
                    </td>
                </tr>
            </table>

        </div>
        <div id="student_table">
            <table id="table_student" border="1" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th style="display: none">ID</th>
                        <th>Họ & tên</th>
                        <th>Ngày sinh</th>
                        <th>Giới tính</th>
                        <th>Khoa</th>      
                        <th>Chức năng</th>  
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sv" items="${studentlist}">
                        <tr>
                            <td style="display: none"><c:out value="${sv.id}" /></td>
                            <td><c:out value="${sv.fullname}" /></td>
                            <td><c:out value="${sv.ngaysinh}" /></td>
                            <td><c:out value="${sv.gioitinh}" /></td>
                            <td><c:out value="${sv.khoa}" /></td>
                            <td> <input type="submit" id="delete"
                                        class="btn btn-danger" value="Delete">    
                                <input type="submit" id="view"
                                       class="btn btn-info" value="View"> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>  

        </div>
        <script>
            function loadtable()
            {
                $("#table_student").DataTable({
                    searching: false,
                    "lengthMenu": [[5, 25, 50, -1], ["10 dòng", "25 dòng", "50 dòng", "All"]],
                    "pagingType": "full_numbers",
                    "bLengthChange": false,
                    "dom": '<"top"p>rt<"bottom"flp><"clear">',
                    "oLanguage": {
                        "sLengthMenu": "Hiển thị _MENU_ ",
                        "oPaginate": {
                            "sFirst": "trang đầu",
                            "sLast": "Last page",
                            "sNext": "Next page",
                            "sPrevious": "Previous page"
                        },
                        "sInfo": "Got a total of _TOTAL_ entries to show (_START_ to _END_)",
                        "sInfoEmpty": "No entries to show",
                    }
                });
            }
            $(function () {
                loadtable();
                $("#datepicker").datepicker({
                    yearRange: "-40:+0",
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "dd-mm-yy"
                });
                $("#save").on('click', function (e) {
                    e.preventDefault();
                    var fullname = $("#fullname").val();
                    var datepicker = $("#datepicker").val();
                    var gioitinh = $("#gioitinh").val();
                    var khoa = $("#khoa").val();
                    console.log(fullname);
                    $.post("addStudent", {Fullname: fullname, Datepicker: datepicker,
                        Gioitinh: gioitinh, Khoa: khoa}, function () {
                        $("#student_table").load(location.href + " #student_table", function () {
                            loadtable();
                        });
                    });
                });
                $("#edit").on('click', function (e) {
                    e.preventDefault();
                    var id = $("#hidden_ID").val();
                    var fullname = $("#fullname").val();
                    var datepicker = $("#datepicker").val();
                    var gioitinh = $("#gioitinh").val();
                    var khoa = $("#khoa").val();
                    $.post("editStudent", {ID: id, Fullname: fullname, Datepicker: datepicker,
                        Gioitinh: gioitinh, Khoa: khoa}, function (data) {
                        $("#student_table").load(location.href + " #student_table", function () {
                            loadtable();

                        });
                    });
                });
                $("#student_table").on('click', '.btn-danger', function (e) {
                    e.preventDefault();
                    var $row = $(this).closest("tr"),
                            $tds = $row.find("td:nth-child(1)");
                    $.each($tds, function () {
                        var ID = $(this).text();
                        $.post("deleteStudent", {ID_Student: ID}, function (data) {
                            $("#student_table").load(location.href + " #student_table",function(){
                                loadtable();
                            });
                        });
                    });
                });
                $("#student_table").on('click', '.btn-info', function (e) {
                    e.preventDefault();
                    var $row = $(this).closest("tr"),
                            $tds = $row.find("td:nth-child(1)");
                    $.each($tds, function () {
                        var ID = $(this).text();
                        var fullname = $(this).next().text();
                        var ngaysinh = $(this).next().next().text();
                        var gioitinh = $(this).next().next().next().text();
                        var khoa = $(this).next().next().next().next().text();
                        console.log(ID);
                        $('#hidden_ID').val(ID);
                        $('#fullname').val(fullname);
                        $('#datepicker').val(ngaysinh);
                        $('#gioitinh').val(gioitinh);
                        $('#khoa').val(khoa);
                    });
                });
            }
            );
        </script>
    </body>
</html>
