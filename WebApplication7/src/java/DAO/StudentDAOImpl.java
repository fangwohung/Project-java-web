/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quochung
 */
public class StudentDAOImpl implements StudentDAO {

    public StudentDAOImpl() {
    }

    @Override
    public List<Student> filterStudents(Student thongtin_tracuu, int start, int total) {
        List<Student> list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "select * from student where Fullname like '%+" + thongtin_tracuu.getFullname() + "' "
                + "and cast(Ngaysinh as char(11)) like '%" + thongtin_tracuu.getNgaysinh() + "' "
                + "and gioitinh like '%" + thongtin_tracuu.getGioitinh() + "' "
                + "and khoa like '%" + thongtin_tracuu.getKhoa() + "' limit ?,?";
        if (con != null) {
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ptm.setInt(1, start);
                ptm.setInt(2, total);
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    Student student = new Student(rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5));
                    list.add(student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Student getStudent(String id) {
        Student student = null;
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT * FROM student where ID = " + id;
        if (con != null) {
            try {
                PreparedStatement ptm = con.prepareStatement(sql);

                ResultSet rs = ptm.executeQuery();
                if (rs.next()) {
                    student = new Student(rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return student;

    }

    @Override
    public int tongsodong() {
        int dem = 0;
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT count(*) FROM student";
        if (con != null) {
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ResultSet rs = ptm.executeQuery();
                if (rs.next()) {
                    dem = rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dem;
    }

    @Override
    public List<Student> getRecordsPerPage(int start, int total) {
        List<Student> list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT * FROM student limit ?,?";
        if (con != null) {
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ptm.setInt(1, start);
                ptm.setInt(2, total);
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    Student student = new Student(rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5));
                    list.add(student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<Student> getListStudents() {
        List<Student> list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT * FROM student";
        if (con != null) {
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    Student student = new Student(rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5));
                    list.add(student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;

    }

    @Override
    public boolean them(Student student) {
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        if (con != null) {
            String query = "insert into student(Fullname,Ngaysinh,gioitinh,khoa) "
                    + "values(?,?,?,?)";
            try {
                PreparedStatement ptm = con.prepareStatement(query);
                ptm.setString(1, student.getFullname());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String stringDate = dateFormat.format(student.getNgaysinh());
                java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
                ptm.setDate(2, sqlDate);
                ptm.setString(3, student.getGioitinh());
                ptm.setString(4, student.getKhoa());
                int check = ptm.executeUpdate();
                if (check != 0) {
                    ptm.close();
                    con.close();
                    return true;
                }
            } catch (SQLException ex) {
            }
        }
        return false;
    }

    @Override
    public boolean xoa(Student student) {
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        if (con != null) {
            String query = "delete from student where ID = " + student.getId();
            try {
                PreparedStatement ptm = con.prepareStatement(query);
                int check = ptm.executeUpdate();
                if (check != 0) {
                    ptm.close();
                    con.close();
                    return true;
                }
            } catch (SQLException ex) {
            }
        }
        return false;
    }

    @Override
    public boolean sua(Student student) {

        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        if (con != null) {
            String query = "update student set Fullname=?,Ngaysinh=?,gioitinh=?,Khoa=? where ID = " + student.getId();
            try {
                PreparedStatement ptm = con.prepareStatement(query);
                ptm.setString(1, student.getFullname());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String stringDate = dateFormat.format(student.getNgaysinh());
                java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
                ptm.setDate(2, sqlDate);
                ptm.setString(3, student.getGioitinh());
                ptm.setString(4, student.getKhoa());
                int check = ptm.executeUpdate();
                if (check != 0) {
                    ptm.close();
                    con.close();
                    return true;
                }
            } catch (SQLException ex) {
            }
        }
        return false;
    }

}
