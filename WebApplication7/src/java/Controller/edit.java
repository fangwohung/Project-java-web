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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quochung
 */
public class edit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet edit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet edit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {           
           
            PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            String idsv = request.getParameter("masv");
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
            Student student  = new Student(Integer.valueOf(idsv), fullname, ngaysinh, gioitinh, khoa);
            StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
            if(studentDAOImpl.sua(student))
            {
                RequestDispatcher rs = request.getRequestDispatcher("Home");
                rs.forward(request, response);
            }
            else
            {
                out.print("Sửa thất bại");
            }
        } catch (ParseException ex) {
            Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
