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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author quochung
 */
public class tracuu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int page = 1;
        int recordsPerPage = 8;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }      
        StudentDAOImpl dao = new StudentDAOImpl();
        List<Student> list = null;
        if (request.getParameter("search") != null) {
            if (request.getParameter("hoten") != null
                    || request.getParameter("ngaysinh") != null
                    || request.getParameter("khoa") != null
                    || request.getParameter("gioitinh") != null) {
                
                String fullname = request.getParameter("hoten");
                String Ngaysinh = request.getParameter("ngaysinh");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date ngaysinh = sdf.parse(Ngaysinh);
                    String gioitinh = request.getParameter("gioitinh");
                    if (gioitinh.equals("1")) {
                        gioitinh = "Nam";
                    } else {
                        gioitinh = "Nữ";
                    }
                    String khoa = request.getParameter("khoa");
                    Student thongtin_tracuu = new Student(fullname, ngaysinh, gioitinh, khoa);
                    list = dao.filterStudents(thongtin_tracuu, (page - 1) * recordsPerPage, recordsPerPage);
                } catch (ParseException ex) {
                    Logger.getLogger(tracuu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            list = dao.getRecordsPerPage((page - 1) * recordsPerPage,
                    recordsPerPage);
        }

        int noOfRecords = dao.tongsodong();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("studentlist", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/tracuu.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
