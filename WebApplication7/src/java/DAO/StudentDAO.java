/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Student;
import java.util.List;

/**
 *
 * @author quochung
 */
public interface StudentDAO {

    public List<Student> getListStudents();

    public boolean them(Student student);

    public boolean xoa(Student student);

    public boolean sua(Student student);
    
    public Student getStudent(String id);
    
    public List<Student> filterStudents(Student thongtin_tracuu,int start, int total);
            
    public List<Student> getRecordsPerPage(int start, int total);
    
    public int tongsodong();
}
