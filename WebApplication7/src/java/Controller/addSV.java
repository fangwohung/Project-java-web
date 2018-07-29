/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StudentDAOImpl;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quochung
 */
public class addSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            String fullname = request.getParameter("fullname");
            String Ngaysinh = request.getParameter("bday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaysinh = sdf.parse(Ngaysinh);
            String gioitinh = request.getParameter("gioitinh");
            if (gioitinh.equals("1")) {
                gioitinh = "Nam";
            } else {
                gioitinh = "Nữ";
            }
            String khoa = request.getParameter("khoa");

            Student student = new Student(fullname, ngaysinh, gioitinh, khoa);
            StudentDAOImpl studentdaoimpl = new StudentDAOImpl();
            if (studentdaoimpl.them(student)) {
                response.sendRedirect("Home");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(" + "Thêm dữ liệu thất bại " + ");");
                out.println("</script>");
            }

        } catch (ParseException ex) {
            Logger.getLogger(addSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}
