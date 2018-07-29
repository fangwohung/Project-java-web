<%-- 
    Document   : forgetpassword
    Created on : Jul 11, 2018, 6:29:08 PM
    Author     : quochung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm mật khẩu</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            var reloadData = 0;
            $(document).ready(function () {
                btn_click();
            });
//            function loadData() {
//                var username = $("#username").val();
//                $("#pw").load("Forgetpw.jsp", {Username: username}, function () {
//                    if (reloadData !== 0)
//                        window.clearTimeout(reloadData);
//                    reloadData = window.setTimeout(loadData, 10000)
//                }).fadeIn("slow");
//            }
            function btn_click() {
                $("#sub").click(function () {
                    var username = $("#username").val();
                    $.post("showpw", {Username: username}, function (data) {
                        $("#pw").html(data);
                    });
                });
            }
        </script>          

    </head>
    <body>
        <h1>Finding password</h1>
        <input type="text" name="username" id="username" placeholder="Enter user name">
        <input type="submit" id="sub" name="sub" value="submit">
        <div id="pw"> 
            <p><c:out value="${password}"/></p>
        </div>
    </body>
</html>
