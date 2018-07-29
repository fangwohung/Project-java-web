/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var reloadData = 0;
$(document).ready(function () {
    btn_click();
});
function loadData() {
    var username = $("#username").val();
    $("#pw").load("Forgetpw.jsp", {Username: username}, function () {
        if (reloadData !== 0)
            window.clearTimeout(reloadData);
        reloadData = window.setTimeout(loadData, 10000)
    }).fadeIn("slow");
}
function btn_click() {

    $("#sub").click(function () {
        var username = $("#username").val();
        $.post("Forgetpw.jsp", {Username: username}, function (data) {
            $("#pw").html(data);
        });
    });
}

